package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    // TODO: move to a helper class
    // those methods are required to check the yaml output is the same and decision to make custom check was made because standard assertEquals does not work with yaml
    // issues with standard assertEquals:
    // yaml may have different order of elements
    // the same value may be represented in different ways (e.g. true/false vs yes/no)
    // order of elements in lists may be different
    // some fields are not important for the comparison
    void assertYamlEquals(String expectedYaml, String actualYaml, String message, String[] ignoreFields) {
        Yaml yaml = new Yaml();
        Map<String, Object> expected = yaml.load(expectedYaml);
        excludeFields(expected, ignoreFields);

        Map<String, Object> actual = yaml.load(actualYaml);
        excludeFields(actual, ignoreFields);
        
        assertMapEquals(expected, actual, message);
    }

    @SuppressWarnings("unchecked")
    void assertMapEquals(Map<String, Object> expected, Map<String, Object> actual, String message) {
        assertEquals(expected.size(), actual.size(), message + ": different size");

        expected.forEach((key, value) -> {
            if (value instanceof Map) {
                assertMapEquals((Map<String, Object>) value, (Map<String, Object>) actual.get(key), message);
            } else if (value instanceof ArrayList) {
                ArrayList<Object> expectedList = (ArrayList<Object>) value;
                ArrayList<Object> actualList = (ArrayList<Object>) actual.get(key);
                assertEquals(expectedList.size(), actualList.size(), message + ": different list size");
                for (int i = 0; i < expectedList.size(); i++) {
                    if (expectedList.get(i) instanceof Map) {
                        assertMapEquals((Map<String, Object>) expectedList.get(i), (Map<String, Object>) actualList.get(i), message);
                    } else {
                        assertTrue(actualList.contains(expectedList.get(i)), message);
                    }
                }
            } else {
                assertEquals(value, actual.get(key), message);
            }
        });
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
