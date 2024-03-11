package com.ticketmaster.structurizr.threagile;

import com.structurizr.model.Element;

public class ThreagileMapElement {
    private Element element;
    private String threagileSize;

    public ThreagileMapElement(Element element, String threagileSize) {
        this.element = element;
        this.threagileSize = threagileSize;
    }
    
    public Element getElement() {
        return element;
    }

    public String getThreagileSize() {
        return threagileSize;
    }
}
