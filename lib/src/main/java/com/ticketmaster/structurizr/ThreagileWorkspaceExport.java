package com.ticketmaster.structurizr;

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
