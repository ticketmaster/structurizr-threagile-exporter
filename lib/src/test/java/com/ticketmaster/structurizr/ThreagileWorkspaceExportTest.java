package com.ticketmaster.structurizr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreagileWorkspaceExportTest {

    @Test
    void fileExtensionReturnsYaml() {
        ThreagileWorkspaceExport threagileWorkspaceExport = new ThreagileWorkspaceExport("some yaml");

        assertEquals("yaml", threagileWorkspaceExport.getFileExtension(), "Expected extension should be yaml");
    }

    @Test
    void definitionReturnsValueFromCtor() {
        ThreagileWorkspaceExport threagileWorkspaceExport = new ThreagileWorkspaceExport("some yaml");

        assertEquals("some yaml", threagileWorkspaceExport.getDefinition(), "Expected to get same value as given in constructor");
    }
}
