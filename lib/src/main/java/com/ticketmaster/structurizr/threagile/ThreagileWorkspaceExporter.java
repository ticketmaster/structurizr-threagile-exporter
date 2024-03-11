package com.ticketmaster.structurizr.threagile;

import com.structurizr.Workspace;
import com.structurizr.export.AbstractWorkspaceExporter;
import com.structurizr.export.WorkspaceExport;

import org.yaml.snakeyaml.Yaml;

public class ThreagileWorkspaceExporter extends AbstractWorkspaceExporter {
    public WorkspaceExport export(Workspace workspace) {
        ThreagileConverter threagileConverter = new ThreagileConverter();
        Model threagileModel = threagileConverter.Convert(workspace);
        if (threagileModel == null) {
            return new ThreagileWorkspaceExport("Empty workspace. Nothing to export.");
        }

        Yaml yaml = new Yaml();
        String yamlString = yaml.dumpAsMap(threagileModel);
        return new ThreagileWorkspaceExport(yamlString);
    }
    
}
