package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.structurizr.Workspace;
import com.structurizr.export.WorkspaceExport;
import com.structurizr.util.WorkspaceUtils;

public class ThreagileWorkspaceExporterTest {

    @Test
    void exportNullWorkspaceReturnEmptyWorkspaceMessage() {
        ThreagileWorkspaceExporter threagileWorkspaceExporter = new ThreagileWorkspaceExporter();

        WorkspaceExport workspaceExport = threagileWorkspaceExporter.export(null);

        assertEquals("Empty workspace. Nothing to export.", workspaceExport.getDefinition());
    }

    @Test
    void exportEmptyWorkspaceReturnValidYaml() {
        assertDoesNotThrow(() -> {
            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/amazon.json"));
    
            ThreagileWorkspaceExporter threagileWorkspaceExporter = new ThreagileWorkspaceExporter();
    
            WorkspaceExport workspaceExport = threagileWorkspaceExporter.export(workspace);

            String expectedResult = new String(Files.readAllBytes(Paths.get("./src/test/resources/amazon_threagile.yaml")));

            assertYamlEquals(expectedResult, workspaceExport.getDefinition(), "Expecting the same yaml", new String[] { "date" });
        });
    }

    void assertYamlEquals(String expectedYaml, String actualYaml, String message, String[] ignoreFields) {
        Yaml yaml = new Yaml();
        Map<String, Object> expected = yaml.load(expectedYaml);
        excludeFields(expected, ignoreFields);

        Map<String, Object> actual = yaml.load(actualYaml);
        excludeFields(actual, ignoreFields);
        
        assertEquals(expected, actual, message);
    }

    @SuppressWarnings("unchecked")
    void excludeFields(Map<String, Object> map, String[] fields) {
        for (String field : fields) {
            map.remove(field);
        }

        map.forEach((key, value) -> {
            if (value instanceof Map) {
                excludeFields((Map<String, Object>) value, fields);
            }
        });
    }
}
