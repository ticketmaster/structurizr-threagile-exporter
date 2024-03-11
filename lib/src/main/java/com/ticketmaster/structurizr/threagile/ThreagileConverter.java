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
        return modelBuilder.WithDefaultValues().WithTagsAvailable(tags).WithTechnicalAssets(technicalAssets).Build();
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
        TechnicalAsset asset = new TechnicalAsset();
        asset.setId(techAssetPrefix + "-" + element.getElement().getId());
        asset.setDescription(element.getElement().getDescription());
        asset.setType(element.getThreagileSize());
        asset.setUsage("business");
        asset.setUsed_as_client_by_human(true);
        asset.setOut_of_scope(false);
        asset.setJustification_out_of_scope("");
        asset.setTechnology("web-server");
        asset.setTags(element.getElement().getTagsAsSet());
        asset.setInternet(true);
        asset.setMachine("virtual");
        asset.setEncryption("none");
        asset.setOwner("Some Owner");
        asset.setConfidentiality("confidential");
        asset.setIntegrity("important");
        asset.setAvailability("important");
        asset.setJustification_cia_rating("Some Justification");
        asset.setSize(element.getThreagileSize());
        asset.setMulti_tenant(false);
        asset.setRedundant(false);
        asset.setCustom_developed_parts(false);
        asset.setData_assets_processed(new String[] {});
        asset.setData_assets_stored(new String[] {});
        asset.setData_formats_accepted(new String[] {});
        asset.setCommunication_links(ConvertElementToCommunicationLinks(element));
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
}
