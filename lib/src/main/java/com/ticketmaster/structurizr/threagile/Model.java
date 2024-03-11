package com.ticketmaster.structurizr.threagile;

import java.util.Map;
import java.util.Set;

public class Model {
    private String threagile_version;
    private String title;
    private String date;
    private Author author;
    private String management_summary_content;
    private String business_criticality;
    private Overview business_overview;
    private Overview technical_overview;
    private Map<String, String> questions;
    private Map<String, String> abuse_cases;
    private Map<String, String> security_requirements;
    private Set<String> tags_available;
    private Map<String, DataAsset> data_assets;
    private Map<String, TechnicalAsset> technical_assets;
    private Map<String, TrustBoundary> trust_boundaries;
    private Map<String, SharedRuntime> shared_runtimes;
    private Map<String, IndividualRiskCategory> individual_risk_categories;
    private Map<String, RiskTracking> risk_tracking;

    public Model() {
        questions = new java.util.HashMap<>();
        abuse_cases = new java.util.HashMap<>();
        security_requirements = new java.util.HashMap<>();
        tags_available = new java.util.HashSet<>();
        data_assets = new java.util.HashMap<>();
        technical_assets = new java.util.HashMap<>();
        trust_boundaries = new java.util.HashMap<>();
        shared_runtimes = new java.util.HashMap<>();
        individual_risk_categories = new java.util.HashMap<>();
        risk_tracking = new java.util.HashMap<>();
    }

    public String getThreagile_version() {
        return threagile_version;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public Author getAuthor() {
        return author;
    }

    public String getManagement_summary_content() {
        return management_summary_content;
    }

    public String getBusiness_criticality() {
        return business_criticality;
    }

    public Overview getTechnical_overview() {
        return technical_overview;
    }

    public Map<String, String> getQuestions() {
        return questions;
    }

    public Map<String, String> getAbuse_cases() {
        return abuse_cases;
    }

    public Map<String, String> getSecurity_requirements() {
        return security_requirements;
    }

    public Set<String> getTags_available() {
        return tags_available;
    }

    public Map<String, DataAsset> getData_assets() {
        return data_assets;
    }

    public Map<String, TechnicalAsset> getTechnical_assets() {
        return technical_assets;
    }

    public Map<String, TrustBoundary> getTrust_boundaries() {
        return trust_boundaries;
    }

    public Map<String, SharedRuntime> getShared_runtimes() {
        return shared_runtimes;
    }

    public Map<String, IndividualRiskCategory> getIndividual_risk_categories() {
        return individual_risk_categories;
    }

    public Map<String, RiskTracking> getRisk_tracking() {
        return risk_tracking;
    }

    public Overview getBusiness_overview() {
        return business_overview;
    }

    public void setThreagile_version(String threagile_version) {
        this.threagile_version = threagile_version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setManagement_summary_content(String management_summary_content) {
        this.management_summary_content = management_summary_content;
    }

    public void setBusiness_criticality(String business_criticality) {
        this.business_criticality = business_criticality;
    }

    public void setTechnical_overview(Overview technical_overview) {
        this.technical_overview = technical_overview;
    }

    public void setQuestions(Map<String, String> questions) {
        this.questions = questions;
    }

    public void setAbuse_cases(Map<String, String> abuse_cases) {
        this.abuse_cases = abuse_cases;
    }

    public void setSecurity_requirements(Map<String, String> security_requirements) {
        this.security_requirements = security_requirements;
    }

    public void setTags_available(Set<String> tags_available) {
        this.tags_available = tags_available;
    }

    public void setData_assets(Map<String, DataAsset> data_assets) {
        this.data_assets = data_assets;
    }

    public void setTechnical_assets(Map<String, TechnicalAsset> technical_assets) {
        this.technical_assets = technical_assets;
    }

    public void setTrust_boundaries(Map<String, TrustBoundary> trust_boundaries) {
        this.trust_boundaries = trust_boundaries;
    }

    public void setShared_runtimes(Map<String, SharedRuntime> shared_runtimes) {
        this.shared_runtimes = shared_runtimes;
    }

    public void setIndividual_risk_categories(Map<String, IndividualRiskCategory> individual_risk_categories) {
        this.individual_risk_categories = individual_risk_categories;
    }

    public void setRisk_tracking(Map<String, RiskTracking> risk_tracking) {
        this.risk_tracking = risk_tracking;
    }

    public void setBusiness_overview(Overview business_overview) {
        this.business_overview = business_overview;
    }

}
