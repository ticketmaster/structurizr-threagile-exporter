package com.ticketmaster.structurizr.threagile;

import java.util.Map;
import java.util.Set;

public class TechnicalAsset {
    private String id;
    private String description;
    private String type;
    private String usage;
    private boolean used_as_client_by_human;
    private boolean out_of_scope;
    private String justification_out_of_scope;
    private String size;
    private String technology;
    private Set<String> tags;
    private boolean internet;
    private String machine;
    private String encryption;
    private String owner;
    private String confidentiality;
    private String integrity;
    private String availability;
    private String justification_cia_rating;
    private boolean multi_tenant;
    private boolean redundant;
    private boolean custom_developed_parts;
    private String[] data_assets_processed;
    private String[] data_assets_stored;
    private String[] data_formats_accepted;
    private Map<String, CommunicationLink> communication_links;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getUsage() {
        return usage;
    }

    public boolean getUsed_as_client_by_human() {
        return used_as_client_by_human;
    }

    public boolean getOut_of_scope() {
        return out_of_scope;
    }

    public String getJustification_out_of_scope() {
        return justification_out_of_scope;
    }

    public String getSize() {
        return size;
    }

    public String getTechnology() {
        return technology;
    }

    public Set<String> getTags() {
        return tags;
    }

    public boolean getInternet() {
        return internet;
    }

    public String getMachine() {
        return machine;
    }

    public String getEncryption() {
        return encryption;
    }

    public String getOwner() {
        return owner;
    }

    public String getConfidentiality() {
        return confidentiality;
    }

    public String getIntegrity() {
        return integrity;
    }

    public String getAvailability() {
        return availability;
    }

    public String getJustification_cia_rating() {
        return justification_cia_rating;
    }

    public boolean getMulti_tenant() {
        return multi_tenant;
    }

    public boolean getRedundant() {
        return redundant;
    }

    public boolean getCustom_developed_parts() {
        return custom_developed_parts;
    }

    public String[] getData_assets_processed() {
        return data_assets_processed;
    }

    public String[] getData_assets_stored() {
        return data_assets_stored;
    }

    public String[] getData_formats_accepted() {
        return data_formats_accepted;
    }

    public Map<String, CommunicationLink> getCommunication_links() {
        return communication_links;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setUsed_as_client_by_human(boolean used_as_client_by_human) {
        this.used_as_client_by_human = used_as_client_by_human;
    }

    public void setOut_of_scope(boolean out_of_scope) {
        this.out_of_scope = out_of_scope;
    }

    public void setJustification_out_of_scope(String justification_out_of_scope) {
        this.justification_out_of_scope = justification_out_of_scope;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setJustification_cia_rating(String justification_cia_rating) {
        this.justification_cia_rating = justification_cia_rating;
    }

    public void setMulti_tenant(boolean multi_tenant) {
        this.multi_tenant = multi_tenant;
    }

    public void setRedundant(boolean redundant) {
        this.redundant = redundant;
    }

    public void setCustom_developed_parts(boolean custom_developed_parts) {
        this.custom_developed_parts = custom_developed_parts;
    }

    public void setData_assets_processed(String[] data_assets_processed) {
        this.data_assets_processed = data_assets_processed;
    }

    public void setData_assets_stored(String[] data_assets_stored) {
        this.data_assets_stored = data_assets_stored;
    }

    public void setData_formats_accepted(String[] data_formats_accepted) {
        this.data_formats_accepted = data_formats_accepted;
    }

    public void setCommunication_links(Map<String, CommunicationLink> communication_links) {
        this.communication_links = communication_links;
    }
}
