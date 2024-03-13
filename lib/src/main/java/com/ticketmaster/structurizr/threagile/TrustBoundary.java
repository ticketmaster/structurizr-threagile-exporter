package com.ticketmaster.structurizr.threagile;

public class TrustBoundary {
    private String id;
    private String description;
    private String type;
    private String[] tags;
    private String[] data_assets;
    private String[] technical_assets_inside;
    private String[] trust_boundaries_nested;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getData_assets() {
        return data_assets;
    }

    public String[] getTechnical_assets_inside() {
        return technical_assets_inside;
    }

    public String[] getTrust_boundaries_nested() {
        return trust_boundaries_nested;
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

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setData_assets(String[] data_assets) {
        this.data_assets = data_assets;
    }

    public void setTechnical_assets_inside(String[] technical_assets_inside) {
        this.technical_assets_inside = technical_assets_inside;
    }

    public void setTrust_boundaries_nested(String[] trust_boundaries_nested) {
        this.trust_boundaries_nested = trust_boundaries_nested;
    }

}
