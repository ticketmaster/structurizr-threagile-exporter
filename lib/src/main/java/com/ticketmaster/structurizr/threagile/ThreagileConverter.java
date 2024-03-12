package com.ticketmaster.structurizr.threagile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.structurizr.Workspace;

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
            result.add(new ThreagileMapElement(softwareSystem, "system"));

            softwareSystem.getContainers().forEach((container) -> {
                result.add(new ThreagileMapElement(container, "application"));

                container.getComponents().forEach((component) -> {
                    result.add(new ThreagileMapElement(component, "component"));
                });
            });
        });

        return result;
    }

    private static Model ProcessElements(ArrayList<ThreagileMapElement> elements) {
        Map<String, TechnicalAsset> technicalAssets = new HashMap<String, TechnicalAsset>();
        Set<String> tags = new HashSet<String>();
        elements.forEach((element) -> {
            element.getElement().getTagsAsSet().forEach((tag) -> {
                tags.add(tag);
            });

            String name = GetUniqueTechnicalAssetName(technicalAssets, element.getElement().getName());
            technicalAssets.put(name, ConvertElementToTechnicalAsset(element));
        });

        ThreagileModelBuilder modelBuilder = new ThreagileModelBuilder();
        return modelBuilder.WithDefaultValues().WithTagsAvailable(ToArray(tags)).WithTechnicalAssets(technicalAssets).Build();
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
            .WithId(techAssetPrefix + "-" + element.getElement().getId())
            .WithDescription(element.getElement().getDescription())
            .WithTags(ToArray(element.getElement().getTagsAsSet()))
            .WithSize(element.getThreagileSize())
            .WithCommunicationLinks(ConvertElementToCommunicationLinks(element))
            .Build();
        return asset;
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
