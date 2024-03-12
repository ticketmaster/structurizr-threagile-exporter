package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class TechnicalAssetBuilderTest {
    
    @Test
    void buildExpectReturnTechnicalAsset() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder.Build();

        assertNotNull(technicalAsset);
    }

    @Test
    void withDefaultValuesExpectSetDefaultValues() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithDefault()
            .Build();

        assertEquals("business", technicalAsset.getUsage());
        assertEquals(true , technicalAsset.getUsed_as_client_by_human());
        assertEquals(false, technicalAsset.getOut_of_scope());
        assertEquals("", technicalAsset.getJustification_out_of_scope());
        assertEquals("web-server", technicalAsset.getTechnology());
        assertEquals(true, technicalAsset.getInternet());
        assertEquals("virtual", technicalAsset.getMachine());
        assertEquals("none", technicalAsset.getEncryption());
        assertEquals("process", technicalAsset.getType());
        assertEquals("Some Owner", technicalAsset.getOwner());
        assertEquals("confidential", technicalAsset.getConfidentiality());
        assertEquals("important", technicalAsset.getIntegrity());
        assertEquals("important", technicalAsset.getAvailability());
        assertEquals("Some Justification", technicalAsset.getJustification_cia_rating());
        assertEquals(false, technicalAsset.getMulti_tenant());
        assertEquals(false, technicalAsset.getRedundant());
        assertEquals(false, technicalAsset.getCustom_developed_parts());
        assertEquals(0, technicalAsset.getData_assets_processed().length);
        assertEquals(0, technicalAsset.getData_assets_stored().length);
        assertEquals(0, technicalAsset.getData_formats_accepted().length);
    }

    @Test
    void withIdExpectSetId() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithId("test")
            .Build();

        assertEquals("test", technicalAsset.getId());
    }

    @Test
    void withDescriptionExpectSetDescription() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithDescription("test")
            .Build();

        assertEquals("test", technicalAsset.getDescription());
    }

    @Test
    void withTagsExpectSetTags() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithTags(new ArrayList<String>(Arrays.asList("test")))
            .Build();

        assertEquals(true, technicalAsset.getTags().contains("test"), "Expecting tag 'test' available");
    }

    @Test
    void withSizeExpectSetSize() {
        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithSize("test")
            .Build();

        assertEquals("test", technicalAsset.getSize());
    }

    @Test
    void withCommunicationLinksExpectSetCommunicationLinks() {
        Map<String, CommunicationLink> communicationLinks = new HashMap<String, CommunicationLink>();
        communicationLinks.put("test", new CommunicationLink());

        TechnicalAssetBuilder technicalAssetBuilder = new TechnicalAssetBuilder();
        
        TechnicalAsset technicalAsset = technicalAssetBuilder
            .WithCommunicationLinks(communicationLinks)
            .Build();

        assertEquals(communicationLinks, technicalAsset.getCommunication_links());
    }
    
}
