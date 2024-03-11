package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.structurizr.export.WorkspaceExport;

public class ThreagileWorkspaceExporterTest {

    @Test
    void exportNullWorkspaceReturnValidYaml() {
        ThreagileWorkspaceExporter threagileWorkspaceExporter = new ThreagileWorkspaceExporter();

        WorkspaceExport workspaceExport = threagileWorkspaceExporter.export(null);

        assertEquals("abuse_cases: null\n" + //
                "author: null\n" + //
                "business_criticality: null\n" + //
                "data_assets: null\n" + //
                "date: null\n" + //
                "individual_risk_categories: null\n" + //
                "management_summary_content: null\n" + //
                "questions: null\n" + //
                "risk_tracking: null\n" + //
                "security_requirements: null\n" + //
                "shared_runtimes: null\n" + //
                "tags_available: null\n" + //
                "technical_assets: null\n" + //
                "technical_overview: null\n" + //
                "threagile_version: null\n" + //
                "title: null\n" + //
                "trust_boundaries: null\n", workspaceExport.getDefinition(), "Expected to get same value as given in export method");
    }
}
