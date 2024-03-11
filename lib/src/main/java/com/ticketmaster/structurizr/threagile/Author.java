package com.ticketmaster.structurizr.threagile;

public class Author {
    private String name;
    private String homePage;

    public Author() {
    }

    public Author(String name, String homePage) {
        this.name = name;
        this.homePage = homePage;
    }

    public String getName() {
        return name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
