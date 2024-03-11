package com.ticketmaster.structurizr.threagile;

import com.structurizr.export.WorkspaceExport;

public class ThreagileWorkspaceExport extends WorkspaceExport {

    public ThreagileWorkspaceExport(String definition) {
        super(definition);
    }

    @Override
    public String getFileExtension() {
        return "yaml";
    }

}
