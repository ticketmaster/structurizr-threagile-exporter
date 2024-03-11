package com.ticketmaster.structurizr.threagile;

import java.util.HashSet;
import java.util.Set;

import com.structurizr.Workspace;

public class ThreagileConverter {
    public Model Convert(Workspace workspace) {
        if (workspace == null) {
            return null;
        }

        HashSet<ThreagileMapElement> elements = GetElements(workspace);
        return ProcessElements(elements);
    }

    private static HashSet<ThreagileMapElement> GetElements(Workspace workspace) {
        HashSet<ThreagileMapElement> result = new HashSet<>();
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

    private static Model ProcessElements(HashSet<ThreagileMapElement> elements) {
        Model result = new Model();

        Set<String> tags = result.getTags_available();

        elements.forEach((element) -> {
            element.getElement().getTagsAsSet().forEach((tag) -> {
                tags.add(tag);
            });
        });

        return result;
    }
}
