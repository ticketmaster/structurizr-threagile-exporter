package com.ticketmaster.structurizr

import kotlin.test.Test
import kotlin.test.assertEquals

class YamlWorkspaceExportTest {
    @Test fun fileExtensionReturnsYaml() {
        val yamlWorkspaceExport = YamlWorkspaceExport("some yaml ")

        assertEquals("yaml", yamlWorkspaceExport.fileExtension, "Expected extension should be yaml")
    }

    @Test fun definitionReturnsValueFromCtor() {
        val yamlWorkspaceExport = YamlWorkspaceExport("some yaml")

        assertEquals("some yaml", yamlWorkspaceExport.definition, "Expected to get same value as given in constructor")
    }
}