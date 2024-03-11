package com.ticketmaster.structurizr.threagile;

import com.structurizr.Workspace;
import com.structurizr.export.AbstractWorkspaceExporter;
import com.structurizr.export.WorkspaceExport;

public class ThreagileWorkspaceExporter extends AbstractWorkspaceExporter {
    public WorkspaceExport export(Workspace workspace) {
        return new ThreagileWorkspaceExport("Some yaml");
    }
}
