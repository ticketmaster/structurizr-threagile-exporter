package com.ticketmaster.structurizr.threagile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.structurizr.Workspace;
import com.structurizr.util.WorkspaceUtils;

public class ThreagileConverterTest {
    
    @Test
    void exportNullWorkspaceReturnValidYaml() {
        ThreagileConverter threagileConverter = new ThreagileConverter();

        Model model = threagileConverter.Convert(null);

        assertNull(model);
    }

    @Test
    void exportExpectGetAllAvailableTags() {
        ThreagileConverter threagileConverter = new ThreagileConverter();

        assertDoesNotThrow(() -> {

            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);

            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/amazon.json"));
            Model model = threagileConverter.Convert(workspace);
            assertNotNull(model);

            Set<String> tags = model.getTags_available();
            assertEquals(5, tags.size(), "Expecting 5 tags available");
            assertEquals(true, tags.contains("Element"), "Expecting tag 'Element' available");
            assertEquals(true, tags.contains("Container"), "Expecting tag 'Container' available");
            assertEquals(true, tags.contains("Database"), "Expecting tag 'Database' available");
            assertEquals(true, tags.contains("Software System"), "Expecting tag 'Software System' available");
            assertEquals(true, tags.contains("Application"), "Expecting tag 'Application' available");
        });
    }
}
