package com.ticketmaster.structurizr.threagile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ThreagileModelBuilder {
    private Model model;

    public ThreagileModelBuilder() {
        this.model = new Model();
    }

    public ThreagileModelBuilder WithDefaultValues() {
        String currentDate = getCurrentDate();
        model.setThreagile_version("1.0.0");
        model.setTitle("Generated Threagile Model");
        model.setDate(currentDate);
        model.setAuthor(new Author("THIS IS GENERATED THREAGILE MODEL OUT OF DSL", "https://github.com/Threagile/threagile"));
        model.setManagement_summary_content("Just some <b>more</b> custom summary possible here...");
        model.setBusiness_criticality("important");
        model.setBusiness_overview(new Overview("Some more <i>demo text</i> here and even images...", new String[]{}));
        model.setTechnical_overview(new Overview("Some more <i>demo text</i> here and even images...", new String[]{}));
        model.setQuestions(new HashMap<String, String>() {{
            put("Some question without an answer", "");
            put("Some question with an answer", "Some Answer");
        }});
        model.setAbuse_cases(new HashMap<String, String>() {{
            put("Some Abuse Case", "Some Description");
        }});
        model.setSecurity_requirements(new HashMap<String, String>() {{
            put("Some Security Requirement", "Some Description");
        }});
        model.setData_assets(new HashMap<String, DataAsset>() {{
            put("Some Data Asset", new DataAsset("some-data-asset", "Some Description", "devops", new String[]{}, "Some Origin", "Some Owner", "many", "confidential", "important", "important", "Some Justification CIA Rating"));
        }});
        model.setShared_runtimes(new HashMap<String, SharedRuntime>() {{
            put("Some Shared Runtime", new SharedRuntime("some-runtime", "Some Description", new String[]{}, new String[]{}));
        }});
        model.setIndividual_risk_categories(new HashMap<String, IndividualRiskCategory>() {{
            put("Some Individual Risk Example", new IndividualRiskCategory("something-strange", 
            "Some Description", 
            "Some Impact", "Some ASVS", "https://example.com", "Some Text Describing the Action...", "Some Text Describing the Mitigation...", "Check if XYZ", "business-side", "repudiation", "Some Text Describing the Detection Logic...", "Some Text Describing the Risk Assessment...", "Some Text Describing the Most Common Types of False Positives...", false, 693, new HashMap<String, IdentifiedRisk>() {{
                put("Example Individual Risk", new IdentifiedRisk("critical", "likely", "medium", "possible", new String[]{}, "some-data-asset", "", "", "", ""));
            }}));
        }});
        model.setRisk_tracking(new HashMap<String, RiskTracking>() {{
            put("container-baseimage-backdooring@fan", new RiskTracking("accepted", "Risk accepted as tolerable", "XYZ-1234", currentDate, "Generated User"));
        }});


        return this;
    }

    public ThreagileModelBuilder WithTitle(String title) {
        model.setTitle(title);
        return this;
    }

    public ThreagileModelBuilder WithTagsAvailable(Set<String> tagsAvailable) {
        model.setTags_available(tagsAvailable);
        return this;
    }

    public ThreagileModelBuilder WithTechnicalAssets(Map<String, TechnicalAsset> technicalAssets) {
        model.setTechnical_assets(technicalAssets);
        return this;
    }

    public ThreagileModelBuilder WithTrustBoundaries(Map<String, TrustBoundary> trustBoundaries) {
        model.setTrust_boundaries(trustBoundaries);
        return this;
    }

    public Model Build() {
        return model;
    }

    private String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
