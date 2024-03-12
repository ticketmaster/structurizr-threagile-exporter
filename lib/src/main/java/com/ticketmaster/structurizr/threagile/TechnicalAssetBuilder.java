package com.ticketmaster.structurizr.threagile;

import java.util.ArrayList;
import java.util.Map;

public class TechnicalAssetBuilder {
    private TechnicalAsset technicalAsset;

    public TechnicalAssetBuilder() {
        technicalAsset = new TechnicalAsset();
    }

    public TechnicalAssetBuilder WithDefault() {
        technicalAsset.setUsage("business");
        technicalAsset.setUsed_as_client_by_human(true);
        technicalAsset.setOut_of_scope(false);
        technicalAsset.setJustification_out_of_scope("");
        technicalAsset.setTechnology("web-server");
        technicalAsset.setInternet(true);
        technicalAsset.setMachine("virtual");
        technicalAsset.setEncryption("none");
        technicalAsset.setType("process");
        technicalAsset.setOwner("Some Owner");
        technicalAsset.setConfidentiality("confidential");
        technicalAsset.setIntegrity("important");
        technicalAsset.setAvailability("important");
        technicalAsset.setJustification_cia_rating("Some Justification");
        technicalAsset.setMulti_tenant(false);
        technicalAsset.setRedundant(false);
        technicalAsset.setCustom_developed_parts(false);
        technicalAsset.setData_assets_processed(new String[] {});
        technicalAsset.setData_assets_stored(new String[] {});
        technicalAsset.setData_formats_accepted(new String[] {});
        return this;
    }

    public TechnicalAssetBuilder WithId(String id) {
        technicalAsset.setId(id);
        return this;
    }

    public TechnicalAssetBuilder WithDescription(String description) {
        technicalAsset.setDescription(description);
        return this;
    }

    public TechnicalAssetBuilder WithTags(ArrayList<String> tags) {
        technicalAsset.setTags(tags);
        return this;
    }

    public TechnicalAssetBuilder WithSize(String size) {
        technicalAsset.setSize(size);
        return this;
    }

    public TechnicalAssetBuilder WithCommunicationLinks(Map<String, CommunicationLink> communicationLinks) {
        technicalAsset.setCommunication_links(communicationLinks);
        return this;
    }

    public TechnicalAsset Build() {
        return technicalAsset;
    }
}
