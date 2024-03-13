package com.ticketmaster.structurizr.threagile;

import java.util.ArrayList;

import com.structurizr.model.Element;

public class ThreagileMapElement {
    private Element element;
    private ArrayList<ThreagileMapElement> children;

    // TODO: rework to be enum, can be only system, service, application, component
    private String threagileSize;

    public ThreagileMapElement(Element element, String threagileSize) {
        this.element = element;
        this.threagileSize = threagileSize;
        this.children = new ArrayList<>();
    }
    
    public Element getElement() {
        return element;
    }

    public String getThreagileSize() {
        return threagileSize;
    }

    public ArrayList<ThreagileMapElement> getChildren() {
        return children;
    }

    public void addChild(ThreagileMapElement child) {
        children.add(child);
    }
}
