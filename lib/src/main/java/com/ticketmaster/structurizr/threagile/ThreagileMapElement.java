package com.ticketmaster.structurizr.threagile;

import com.structurizr.model.Element;
import com.structurizr.model.ModelItem;

public class ThreagileMapElement {
    private ModelItem element;
    private String threagileSize;

    public ThreagileMapElement(ModelItem element, String threagileSize) {
        this.element = element;
        this.threagileSize = threagileSize;
    }
    
    public ModelItem getElement() {
        return element;
    }

    public String getThreagileSize() {
        return threagileSize;
    }
}
