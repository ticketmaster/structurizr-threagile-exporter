package com.ticketmaster.structurizr.threagile;

public class IdentifiedRisk {
    private String severity;
    private String exploitation_likelihood;
    private String exploitation_impact;
    private String data_breach_probability;
    private String[] data_breach_technical_assets;
    private String most_relevant_data_asset;
    private String most_relevant_technical_asset;
    private String most_relevant_communication_link;
    private String most_relevant_trust_boundary;
    private String most_relevant_shared_runtime;

    public String getSeverity() {
        return severity;
    }

    public String getExploitation_likelihood() {
        return exploitation_likelihood;
    }

    public String getExploitation_impact() {
        return exploitation_impact;
    }

    public String getData_breach_probability() {
        return data_breach_probability;
    }

    public String[] getData_breach_technical_assets() {
        return data_breach_technical_assets;
    }

    public String getMost_relevant_data_asset() {
        return most_relevant_data_asset;
    }

    public String getMost_relevant_technical_asset() {
        return most_relevant_technical_asset;
    }

    public String getMost_relevant_communication_link() {
        return most_relevant_communication_link;
    }

    public String getMost_relevant_trust_boundary() {
        return most_relevant_trust_boundary;
    }

    public String getMost_relevant_shared_runtime() {
        return most_relevant_shared_runtime;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setExploitation_likelihood(String exploitation_likelihood) {
        this.exploitation_likelihood = exploitation_likelihood;
    }

    public void setExploitation_impact(String exploitation_impact) {
        this.exploitation_impact = exploitation_impact;
    }

    public void setData_breach_probability(String data_breach_probability) {
        this.data_breach_probability = data_breach_probability;
    }

    public void setData_breach_technical_assets(String[] data_breach_technical_assets) {
        this.data_breach_technical_assets = data_breach_technical_assets;
    }

    public void setMost_relevant_data_asset(String most_relevant_data_asset) {
        this.most_relevant_data_asset = most_relevant_data_asset;
    }

    public void setMost_relevant_technical_asset(String most_relevant_technical_asset) {
        this.most_relevant_technical_asset = most_relevant_technical_asset;
    }

    public void setMost_relevant_communication_link(String most_relevant_communication_link) {
        this.most_relevant_communication_link = most_relevant_communication_link;
    }

    public void setMost_relevant_trust_boundary(String most_relevant_trust_boundary) {
        this.most_relevant_trust_boundary = most_relevant_trust_boundary;
    }

    public void setMost_relevant_shared_runtime(String most_relevant_shared_runtime) {
        this.most_relevant_shared_runtime = most_relevant_shared_runtime;
    }

}
