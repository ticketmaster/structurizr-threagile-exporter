package com.ticketmaster.structurizr

import kotlin.test.Test
import kotlin.test.assertEquals

class ThreagileWorkspaceExporterTest {
    @Test fun exportReturnsYamlWorkspaceExport() {
        val threagileWorkspaceExporter = ThreagileWorkspaceExporter()

        val workspaceExport = threagileWorkspaceExporter.export(null)

        assertEquals("Some yaml", workspaceExport.definition, "Expected to get same value as given in export method")
    }
}