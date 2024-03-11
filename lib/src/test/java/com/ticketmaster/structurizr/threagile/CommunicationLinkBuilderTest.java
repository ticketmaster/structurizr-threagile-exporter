package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;

import com.structurizr.Workspace;
import com.structurizr.model.Model;
import com.structurizr.model.Relationship;
import com.structurizr.model.SoftwareSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

public class CommunicationLinkBuilderTest {
    @Test
    void buildExpectReturnCommunicationLink() {
        CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
        
        CommunicationLink communicationLink = communicationLinkBuilder.Build();

        assertNotNull(communicationLink);
    }

    @Test
    void fromRelationshipExpectSetDescription() {
        Relationship relationship = createRelationship("test", "some-technology");
        CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
        
        CommunicationLink communicationLink = communicationLinkBuilder
            .From(relationship)
            .Build();

        assertEquals("test", communicationLink.getDescription());
    }

    @Test
    void fromRelationshipExpectSetProtocol() {
        HashMap<String, String> testCases = new HashMap<String, String>();
        testCases.put("i/o", "local-file-access");
        testCases.put("wss/graphql", "wss");
        testCases.put("", "http");
        testCases.put("browser", "http");
        testCases.put("tcp", "http");
        testCases.put("http/browser", "http");
        testCases.put("application/json", "http");
        testCases.put("graphql", "http");
        testCases.put("some-technology", "some-technology");

        for (String technology : testCases.keySet()) {
            Relationship relationship = createRelationship("test", technology);
            CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
            
            CommunicationLink communicationLink = communicationLinkBuilder
                .From(relationship)
                .Build();

            assertEquals(testCases.get(technology), communicationLink.getProtocol());
        }
    }

    @Test
    void fromRelationshipWhenNullTechnologyExpectSetDefaultProtocol() {
        Relationship relationship = createRelationship("test", null);
        CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
        
        CommunicationLink communicationLink = communicationLinkBuilder
            .From(relationship)
            .Build();

        assertEquals("http", communicationLink.getProtocol());
    }

    @Test
    void withDefaultExpectSetDefaultValues() {
        CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
        
        CommunicationLink communicationLink = communicationLinkBuilder
            .WithDefault()
            .Build();

        assertEquals("none", communicationLink.getAuthentication());
        assertEquals("none", communicationLink.getAuthorization());
        assertEquals(0, communicationLink.getTags().length);
        assertEquals(false, communicationLink.getVpn());
        assertEquals(false, communicationLink.getIp_filtered());
        assertEquals(false, communicationLink.getReadonly());
        assertEquals("business", communicationLink.getUsage());
        assertEquals(0, communicationLink.getData_assets_sent().length);
        assertEquals(0, communicationLink.getData_assets_received().length);
    }

    @Test
    void withTargetIdExpectSetTarget() {
        CommunicationLinkBuilder communicationLinkBuilder = new CommunicationLinkBuilder();
        
        CommunicationLink communicationLink = communicationLinkBuilder
            .WithTargetId("test")
            .Build();

        assertEquals("test", communicationLink.getTarget());
    }

    @SuppressWarnings("null")
    // this workaround is required because Relationship constructor is package-private
    private Relationship createRelationship(String description, String technology) {
        Workspace workspace = new Workspace("test", "test");
        Model model = workspace.getModel();
        model.addSoftwareSystem("softwareSystemFrom", "someDescription");
        model.addSoftwareSystem("softwareSystemTo", "someDescription");
        SoftwareSystem softwareSystemFrom = model.getSoftwareSystemWithName("softwareSystemFrom");
        SoftwareSystem softwareSystemTo = model.getSoftwareSystemWithName("softwareSystemTo");
        return softwareSystemFrom.uses(softwareSystemTo, description, technology);
    }
}
