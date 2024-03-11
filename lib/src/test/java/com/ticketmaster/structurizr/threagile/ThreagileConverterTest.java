package com.ticketmaster.structurizr.threagile;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ThreagileConverterTest {
    
    @Test
    void exportNullWorkspaceReturnValidYaml() {
        ThreagileConverter threagileConverter = new ThreagileConverter();

        Model model = threagileConverter.Convert(null);

        assertNotNull(model);
    }
}
