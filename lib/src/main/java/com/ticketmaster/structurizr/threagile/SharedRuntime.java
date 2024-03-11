package com.ticketmaster.structurizr.threagile;

public class SharedRuntime {
    private String id;
    private String description;
    private String[] tags;
    private String[] technical_assets_running;

    public SharedRuntime() {
    }

    public SharedRuntime(String id, String description, String[] tags, String[] technical_assets_running) {
        this.id = id;
        this.description = description;
        this.tags = tags;
        this.technical_assets_running = technical_assets_running;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getTechnical_assets_running() {
        return technical_assets_running;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setTechnical_assets_running(String[] technical_assets_running) {
        this.technical_assets_running = technical_assets_running;
    }

}
