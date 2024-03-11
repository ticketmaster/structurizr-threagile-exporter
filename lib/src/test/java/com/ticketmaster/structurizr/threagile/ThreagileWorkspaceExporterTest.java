package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.structurizr.export.WorkspaceExport;

public class ThreagileWorkspaceExporterTest {

    @Test
    void fileExtensionReturnsYaml() {
        ThreagileWorkspaceExporter threagileWorkspaceExporter = new ThreagileWorkspaceExporter();

        WorkspaceExport workspaceExport = threagileWorkspaceExporter.export(null);

        assertEquals("Some yaml", workspaceExport.getDefinition(), "Expected to get same value as given in export method");
    }
}
