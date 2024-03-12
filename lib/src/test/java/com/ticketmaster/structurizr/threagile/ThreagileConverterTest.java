package com.ticketmaster.structurizr.threagile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.Map;
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
    void convertExpectGetAllAvailableTags() {
        assertDoesNotThrow(() -> {
            ThreagileConverter threagileConverter = new ThreagileConverter();

            String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);

            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/amazon.json"));
            Model model = threagileConverter.Convert(workspace);
            assertNotNull(model);

            Set<String> tags = model.getTags_available();
            assertEquals(7, tags.size(), "Expecting 7 tags available");
            assertEquals(true, tags.contains("Element"), "Expecting tag 'Element' available");
            assertEquals(true, tags.contains("Container"), "Expecting tag 'Container' available");
            assertEquals(true, tags.contains("Component"), "Expecting tag 'Component' available");
            assertEquals(true, tags.contains("Database"), "Expecting tag 'Database' available");
            assertEquals(true, tags.contains("Software System"), "Expecting tag 'Software System' available");
            assertEquals(true, tags.contains("Application"), "Expecting tag 'Application' available");
            assertEquals(true, tags.contains("Person"), "Expecting tag 'Person' available");
        });
    }

    @Test
    void convertExpectGetAllTechnicalAssetsWithCommunicationLinks() {
        assertDoesNotThrow(() -> {
            ThreagileConverter threagileConverter = new ThreagileConverter();
            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/amazon.json"));
            Model model = threagileConverter.Convert(workspace);
            assertNotNull(model);

            Map<String, TechnicalAsset> technicalAssets = model.getTechnical_assets();
            assertEquals(5, technicalAssets.size(), "Expecting 5 technical assets");

            TechnicalAsset softwareSystemTechnicalAsset = technicalAssets.get("Spring PetClinic");
            assertNotNull(softwareSystemTechnicalAsset);
            assertEquals("ta-1", softwareSystemTechnicalAsset.getId());
            assertEquals(0, softwareSystemTechnicalAsset.getCommunication_links().size(), "Expecting 0 communication links");
            assertEquals("system", softwareSystemTechnicalAsset.getSize());

            TechnicalAsset applicationTechnicalAsset = technicalAssets.get("Web Application");
            assertNotNull(applicationTechnicalAsset);
            assertEquals("ta-2", applicationTechnicalAsset.getId());
            assertEquals("application", applicationTechnicalAsset.getSize());


            Map<String, CommunicationLink> communicationLinks = applicationTechnicalAsset.getCommunication_links();
            assertEquals(1, communicationLinks.size(), "Expecting 1 communication link");
            CommunicationLink communicationLink = communicationLinks.get("to-ta-3");
            assertNotNull(communicationLink);
            assertEquals("ta-3", communicationLink.getTarget());

            TechnicalAsset databaseTechnicalAsset = technicalAssets.get("Database");
            assertNotNull(databaseTechnicalAsset);
            assertEquals("ta-3", databaseTechnicalAsset.getId());
            assertEquals(0, databaseTechnicalAsset.getCommunication_links().size(), "Expecting 0 communication links");
            assertEquals("application", databaseTechnicalAsset.getSize());

            TechnicalAsset personTechnicalAsset = technicalAssets.get("Employee");
            assertNotNull(personTechnicalAsset);
            assertEquals("ta-0", personTechnicalAsset.getId());
            assertEquals(0, personTechnicalAsset.getCommunication_links().size(), "Expecting 0 communication links");
            assertEquals("component", personTechnicalAsset.getSize());

            TechnicalAsset databaseSchemaTechnicalAsset = technicalAssets.get("Database Schema");
            assertNotNull(databaseSchemaTechnicalAsset);
            assertEquals("ta-18", databaseSchemaTechnicalAsset.getId());
            assertEquals(0, databaseSchemaTechnicalAsset.getCommunication_links().size(), "Expecting 0 communication links");
            assertEquals("component", databaseSchemaTechnicalAsset.getSize());
        });
    }

    @Test
    void convertExpectGenerateNameForDuplicatelyNamedTechnicalAssets() {
        assertDoesNotThrow(() -> {
            ThreagileConverter threagileConverter = new ThreagileConverter();
            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/duplicate_name.json"));
            Model model = threagileConverter.Convert(workspace);
            assertNotNull(model);

            Map<String, TechnicalAsset> technicalAssets = model.getTechnical_assets();
            assertEquals(3, technicalAssets.size(), "Expecting 3 technical assets");

            TechnicalAsset technicalAsset1 = technicalAssets.get("The Application");
            assertNotNull(technicalAsset1);
            assertEquals("ta-1", technicalAsset1.getId());
            assertEquals("system", technicalAsset1.getSize());

            TechnicalAsset technicalAsset2 = technicalAssets.get("The Application-2");
            assertNotNull(technicalAsset2);
            assertEquals("ta-2", technicalAsset2.getId());
            assertEquals("application", technicalAsset2.getSize());

            TechnicalAsset technicalAsset3 = technicalAssets.get("The Application-3");
            assertNotNull(technicalAsset3);
            assertEquals("ta-3", technicalAsset3.getId());
            assertEquals("component", technicalAsset3.getSize());
        });
    }

    @Test 
    void convertExpectAssumptionOnProtocolBasedOnTechnology() {
        assertDoesNotThrow(() -> {
            ThreagileConverter threagileConverter = new ThreagileConverter();
            Workspace workspace = WorkspaceUtils.loadWorkspaceFromJson(new File("./src/test/resources/protocol_based_on_technology.json"));
            Model model = threagileConverter.Convert(workspace);
            assertNotNull(model);

            Map<String, TechnicalAsset> technicalAssets = model.getTechnical_assets();
            assertEquals(10, technicalAssets.size(), "Expecting 10 technical assets");

            TechnicalAsset chatApplication = technicalAssets.get("The Chat Application");
            assertNotNull(chatApplication);
            
            Map<String, CommunicationLink> communicationLinks = chatApplication.getCommunication_links();
            assertEquals(9, communicationLinks.size());

            CommunicationLink defaultTechnologyCommunicationLink = communicationLinks.get("to-ta-1");
            assertNotNull(defaultTechnologyCommunicationLink);
            assertEquals("http", defaultTechnologyCommunicationLink.getProtocol());

            CommunicationLink localFileSystemCommunicationLink = communicationLinks.get("to-ta-4");
            assertNotNull(localFileSystemCommunicationLink);
            assertEquals("local-file-access", localFileSystemCommunicationLink.getProtocol());

            CommunicationLink wssCommunicationLink = communicationLinks.get("to-ta-6");
            assertNotNull(wssCommunicationLink);
            assertEquals("wss", wssCommunicationLink.getProtocol());

            CommunicationLink browserCommunicationLink = communicationLinks.get("to-ta-8");
            assertNotNull(browserCommunicationLink);
            assertEquals("http", browserCommunicationLink.getProtocol());

            CommunicationLink tcpCommunicationLink = communicationLinks.get("to-ta-10");
            assertNotNull(tcpCommunicationLink);
            assertEquals("http", tcpCommunicationLink.getProtocol());

            CommunicationLink httpBrowserCommunicationLink = communicationLinks.get("to-ta-12");
            assertNotNull(httpBrowserCommunicationLink);
            assertEquals("http", httpBrowserCommunicationLink.getProtocol());

            CommunicationLink jsonCommunicationLink = communicationLinks.get("to-ta-14");
            assertNotNull(jsonCommunicationLink);
            assertEquals("http", jsonCommunicationLink.getProtocol());

            CommunicationLink graphQlCommunicationLink2 = communicationLinks.get("to-ta-16");
            assertNotNull(graphQlCommunicationLink2);
            assertEquals("http", graphQlCommunicationLink2.getProtocol());

            CommunicationLink customTechnologyCommunicationLink = communicationLinks.get("to-ta-18");
            assertNotNull(customTechnologyCommunicationLink);
            assertEquals("custom-protocol", customTechnologyCommunicationLink.getProtocol());
        });
    }
}
