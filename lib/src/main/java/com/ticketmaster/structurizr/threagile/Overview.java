package com.ticketmaster.structurizr.threagile;

public class Overview {
    private String description;
    private String[] images;

    public Overview(String description, String[] images) {
        this.description = description;
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public String[] getImages() {
        return images;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
