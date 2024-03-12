package com.ticketmaster.structurizr.threagile;

import java.util.ArrayList;

public class TrustBoundary {
    private String id;
    private String description;
    private ArrayList<String> tags;
    private ArrayList<String> data_assets;
    private ArrayList<String> technical_assets_inside;
    private ArrayList<String> trust_boundaries_nested;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public ArrayList<String> getData_assets() {
        return data_assets;
    }

    public ArrayList<String> getTechnical_assets_inside() {
        return technical_assets_inside;
    }

    public ArrayList<String> getTrust_boundaries_nested() {
        return trust_boundaries_nested;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setData_assets(ArrayList<String> data_assets) {
        this.data_assets = data_assets;
    }

    public void setTechnical_assets_inside(ArrayList<String> technical_assets_inside) {
        this.technical_assets_inside = technical_assets_inside;
    }

    public void setTrust_boundaries_nested(ArrayList<String> trust_boundaries_nested) {
        this.trust_boundaries_nested = trust_boundaries_nested;
    }

}
