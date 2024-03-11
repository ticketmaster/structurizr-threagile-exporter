package com.ticketmaster.structurizr.threagile;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ThreagileModelBuilderTest {
    @Test
    void buildExpectReturnThreagileModel() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder.Build();

        assertNotNull(model);
    }

    @Test
    void defaultValuesExpectHaveVersion() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("1.0.0", model.getThreagile_version());
    }

    @Test 
    void defaultValuesExpectHaveTitle() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("Generated Threagile Model", model.getTitle());
    }

    @Test
    void defaultValuesExpectHaveAuthor() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("THIS IS GENERATED THREAGILE MODEL OUT OF DSL", model.getAuthor().getName());
        assertEquals("https://github.com/Threagile/threagile", model.getAuthor().getHomePage());
    }

    @Test
    void defaultValuesExpectHaveManagementSummaryContent() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("Just some <b>more</b> custom summary possible here...", model.getManagement_summary_content());
    }

    @Test
    void defaultValuesExpectHaveBusinessCriticality() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("important", model.getBusiness_criticality());
    }

    @Test
    void defaultValuesExpectHaveBusinessOverview() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("Some more <i>demo text</i> here and even images...", model.getBusiness_overview().getDescription());
        assertEquals(0, model.getBusiness_overview().getImages().length);
    }

    @Test
    void defaultValuesExpectHaveTechnicalOverview() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals("Some more <i>demo text</i> here and even images...", model.getTechnical_overview().getDescription());
        assertEquals(0, model.getTechnical_overview().getImages().length);
    }

    @Test
    void defaultValuesExpectHaveQuestions() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(2, model.getQuestions().size());
        assertEquals("", model.getQuestions().get("Some question without an answer"));
        assertEquals("Some Answer", model.getQuestions().get("Some question with an answer"));
    }

    @Test
    void defaultValuesExpectHaveAbuseCases() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getAbuse_cases().size());
        assertEquals("Some Description", model.getAbuse_cases().get("Some Abuse Case"));
    }

    @Test
    void defaultValuesExpectHaveSecurityRequirements() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getSecurity_requirements().size());
        assertEquals("Some Description", model.getSecurity_requirements().get("Some Security Requirement"));
    }

    @Test
    void defaultValuesExpectHaveDataAssets() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getData_assets().size());

        DataAsset dataAsset = model.getData_assets().get("Some Data Asset");
        assertEquals("some-data-asset", dataAsset.getId());
        assertEquals("Some Description", dataAsset.getDescription());
        assertEquals("devops", dataAsset.getUsage());
        assertEquals(0, dataAsset.getTags().length);
        assertEquals("Some Origin", dataAsset.getOrigin());
        assertEquals("Some Owner", dataAsset.getOwner());
        assertEquals("many", dataAsset.getQuantity());
        assertEquals("confidential", dataAsset.getConfidentiality());
        assertEquals("important", dataAsset.getIntegrity());
        assertEquals("important", dataAsset.getAvailability());
        assertEquals("Some Justification CIA Rating", dataAsset.getJustification_cia_rating());
    }

    @Test
    void defaultValuesExpectHaveSharedRuntimes() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getShared_runtimes().size());

        SharedRuntime sharedRuntime = model.getShared_runtimes().get("Some Shared Runtime");
        assertEquals("some-runtime", sharedRuntime.getId());
        assertEquals("Some Description", sharedRuntime.getDescription());
        assertEquals(0, sharedRuntime.getTags().length);
        assertEquals(0, sharedRuntime.getTechnical_assets_running().length);
    }

    @Test
    void defaultValuesExpectHaveIndividualRiskCategories() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getIndividual_risk_categories().size());

        IndividualRiskCategory individualRiskCategory = model.getIndividual_risk_categories().get("Some Individual Risk Example");
        assertEquals("something-strange", individualRiskCategory.getId());
        assertEquals("Some Description", individualRiskCategory.getDescription());
        assertEquals("Some Impact", individualRiskCategory.getImpact());
        assertEquals("Some ASVS", individualRiskCategory.getAsvs());
        assertEquals("https://example.com", individualRiskCategory.getCheat_sheet());
        assertEquals("Some Text Describing the Action...", individualRiskCategory.getAction());
        assertEquals("Some Text Describing the Mitigation...", individualRiskCategory.getMitigation());
        assertEquals("Check if XYZ", individualRiskCategory.getCheck());
        assertEquals("business-side", individualRiskCategory.getFunction());
        assertEquals("repudiation", individualRiskCategory.getStride());
        assertEquals("Some Text Describing the Detection Logic...", individualRiskCategory.getDetection_logic());
        assertEquals("Some Text Describing the Risk Assessment...", individualRiskCategory.getRisk_assessment());
        assertEquals("Some Text Describing the Most Common Types of False Positives...", individualRiskCategory.getFalse_positives());
        assertEquals(false, individualRiskCategory.getModel_failure_possible_reason());
        
        assertEquals(1, individualRiskCategory.getRisks_identified().size());
        
        IdentifiedRisk identifiedRisk = individualRiskCategory.getRisks_identified().get("Example Individual Risk");
        assertEquals("critical", identifiedRisk.getSeverity());
        assertEquals("likely", identifiedRisk.getExploitation_likelihood());
        assertEquals("medium", identifiedRisk.getExploitation_impact());
        assertEquals("possible", identifiedRisk.getData_breach_probability());
        assertEquals(0, identifiedRisk.getData_breach_technical_assets().length);
        assertEquals("some-data-asset", identifiedRisk.getMost_relevant_data_asset());
        assertEquals("", identifiedRisk.getMost_relevant_technical_asset());
        assertEquals("", identifiedRisk.getMost_relevant_communication_link());
        assertEquals("", identifiedRisk.getMost_relevant_trust_boundary());
        assertEquals("", identifiedRisk.getMost_relevant_shared_runtime());
    }

    @Test
    void defaultValuesExpectHaveRiskTracking() {
        ThreagileModelBuilder threagileModelBuilder = new ThreagileModelBuilder();
        
        Model model = threagileModelBuilder
            .WithDefaultValues()
            .Build();

        assertEquals(1, model.getRisk_tracking().size());

        RiskTracking riskTracking = model.getRisk_tracking().get("container-baseimage-backdooring@fan");
        assertEquals("accepted", riskTracking.getStatus());
        assertEquals("Risk accepted as tolerable", riskTracking.getJustification());
        assertEquals("XYZ-1234", riskTracking.getTicket());
        // TODO: check date in yyyy-MM-dd format assertEquals("2021-01-01", riskTracking.getDate());
        assertEquals("Generated User", riskTracking.getChecked_by());
    }
}
