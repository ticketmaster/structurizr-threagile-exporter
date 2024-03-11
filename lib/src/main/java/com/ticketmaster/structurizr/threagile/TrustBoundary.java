package com.ticketmaster.structurizr.threagile;

import java.util.HashSet;
import java.util.Set;

public class TrustBoundary {
    private String id;
    private String description;
    private Set<String> tags;
    private Set<String> data_assets;
    private Set<String> technical_assets_inside;
    private Set<String> trust_boundaries_nested;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getTags() {
        return tags;
    }

    public Set<String> getData_assets() {
        return data_assets;
    }

    public Set<String> getTechnical_assets_inside() {
        return technical_assets_inside;
    }

    public Set<String> getTrust_boundaries_nested() {
        return trust_boundaries_nested;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setData_assets(Set<String> data_assets) {
        this.data_assets = data_assets;
    }

    public void setTechnical_assets_inside(Set<String> technical_assets_inside) {
        this.technical_assets_inside = technical_assets_inside;
    }

    public void setTrust_boundaries_nested(Set<String> trust_boundaries_nested) {
        this.trust_boundaries_nested = trust_boundaries_nested;
    }

}
