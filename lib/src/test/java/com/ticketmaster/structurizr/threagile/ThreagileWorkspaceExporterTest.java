package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.structurizr.export.WorkspaceExport;

public class ThreagileWorkspaceExporterTest {

    @Test
    void exportNullWorkspaceReturnValidYaml() {
        ThreagileWorkspaceExporter threagileWorkspaceExporter = new ThreagileWorkspaceExporter();

        WorkspaceExport workspaceExport = threagileWorkspaceExporter.export(null);

        assertEquals("Empty workspace. Nothing to export.", workspaceExport.getDefinition());
    }
}
