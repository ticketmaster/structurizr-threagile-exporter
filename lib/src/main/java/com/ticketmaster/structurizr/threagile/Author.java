package com.ticketmaster.structurizr.threagile;

public class Author {
    private String name;
    private String homepage;

    public Author() {
    }

    public Author(String name, String homepage) {
        this.name = name;
        this.homepage = homepage;
    }

    public String getName() {
        return name;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
