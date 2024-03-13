package com.ticketmaster.structurizr.threagile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.structurizr.Workspace;
import com.structurizr.model.Element;

public class ThreagileConverter {
    private static final String techAssetPrefix = "ta";

    public Model Convert(Workspace workspace) {
        if (workspace == null) {
            return null;
        }

        ArrayList<ThreagileMapElement> elements = GetElements(workspace);
        return ProcessElements(elements);
    }

    private static ArrayList<ThreagileMapElement> GetElements(Workspace workspace) {
        ArrayList<ThreagileMapElement> result = new ArrayList<>();
        workspace.getModel().getPeople().forEach((person) -> {
            result.add(new ThreagileMapElement(person, "component"));
        });

        workspace.getModel().getSoftwareSystems().forEach((softwareSystem) -> {
            ThreagileMapElement system = new ThreagileMapElement(softwareSystem, "system");
            result.add(system);

            softwareSystem.getContainers().forEach((container) -> {
                ThreagileMapElement application = new ThreagileMapElement(container, "application");
                result.add(application);
                system.addChild(application);

                container.getComponents().forEach((component) -> {
                    ThreagileMapElement componentMapElement = new ThreagileMapElement(component, "component");
                    result.add(componentMapElement);
                    system.addChild(componentMapElement);
                    application.addChild(componentMapElement);
                });
            });
        });

        return result;
    }

    private static Model ProcessElements(ArrayList<ThreagileMapElement> elements) {
        Map<String, TechnicalAsset> technicalAssets = new HashMap<String, TechnicalAsset>();
        Map<String, TrustBoundary> trustBoundaries = new HashMap<String, TrustBoundary>();
        Map<String, SharedRuntime> sharedRuntimes = new HashMap<String, SharedRuntime>();
        Set<String> tags = new HashSet<String>();
        elements.forEach((element) -> {
            element.getElement().getTagsAsSet().forEach((tag) -> {
                tags.add(tag);
            });

            String name = GetUniqueTechnicalAssetName(technicalAssets, element.getElement().getName());
            TechnicalAsset asset = ConvertElementToTechnicalAsset(element);
            technicalAssets.put(name, asset);

            if (element.getChildren().size() > 0 && element.getThreagileSize() == "application") {
                SharedRuntime sharedRuntime = new SharedRuntime();
                sharedRuntime.setId("sr-" + element.getElement().getId());
                sharedRuntime.setDescription("Inside application which " + element.getElement().getDescription());
                sharedRuntime.setTechnical_assets_running(GetTechnicalAssetIds(element)) ;
                sharedRuntimes.put("application-" + asset.getId(), sharedRuntime);
            }

            if (element.getChildren().size() > 0 && element.getThreagileSize() == "system") {
                TrustBoundary trustBoundary = new TrustBoundary();
                trustBoundary.setId("tb-" + element.getElement().getId());
                trustBoundary.setType("execution-environment");
                trustBoundary.setDescription("Inside software system which " + element.getElement().getDescription());
                trustBoundary.setTechnical_assets_inside(GetTechnicalAssetIds(element));
                trustBoundaries.put("software-system-" + asset.getId(), trustBoundary);
            }
        });

        ThreagileModelBuilder modelBuilder = new ThreagileModelBuilder();
        return modelBuilder.WithDefaultValues()
                  .WithTagsAvailable(ToArray(tags))
                  .WithTechnicalAssets(technicalAssets)
                  .WithSharedRuntimes(sharedRuntimes)
                  .WithTrustBoundaries(trustBoundaries)
                  .Build();
    }

    private static String[] GetTechnicalAssetIds(ThreagileMapElement element) {
        return Stream.concat(element.getChildren().stream(), Stream.of(element)).map((child) -> {
            return GetId(child.getElement());
        }).toArray(String[]::new);
    }

    private static String GetUniqueTechnicalAssetName(Map<String, TechnicalAsset> technicalAssets, String name) {
        String result = name;
        Integer suffix = 2;
        while (technicalAssets.containsKey(result)) {
            result = name + "-" + suffix;
            suffix++;
        }
        return result;
    }

    private static TechnicalAsset ConvertElementToTechnicalAsset(ThreagileMapElement element) {
        TechnicalAssetBuilder builder = new TechnicalAssetBuilder();

        TechnicalAsset asset = builder
            .WithDefault()
            .WithId(GetId(element.getElement()))
            .WithDescription(element.getElement().getDescription())
            .WithTags(ToArray(element.getElement().getTagsAsSet()))
            .WithSize(element.getThreagileSize())
            .WithCommunicationLinks(ConvertElementToCommunicationLinks(element))
            .Build();
        return asset;
    }

    private static String GetId(Element element) {
        return techAssetPrefix + "-" + element.getId();
    } 

    private static Map<String, CommunicationLink> ConvertElementToCommunicationLinks(ThreagileMapElement element) {
        Map<String, CommunicationLink> result = new HashMap<String, CommunicationLink>();
        element.getElement().getRelationships().forEach((relationship) -> {
            String targetId = techAssetPrefix + '-' + relationship.getDestinationId();

            CommunicationLinkBuilder builder = new CommunicationLinkBuilder();
            CommunicationLink link = builder.From(relationship).WithDefault().WithTargetId(targetId).Build();

            result.put("to-" + targetId, link);
        });
        return result;
    }

    // TODO: move to utils class
    private static ArrayList<String> ToArray(Set<String> set) {
        ArrayList<String> result = new ArrayList<String>();
        set.forEach((item) -> {
            result.add(item);
        });
        return result;
    }
}
