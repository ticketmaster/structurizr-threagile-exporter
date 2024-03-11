package com.ticketmaster.structurizr.threagile;

import java.util.Map;

public class IndividualRiskCategory {
    private String id;
    private String description;
    private String impact;
    private String asvs;
    private String cheat_sheet;
    private String action;
    private String mitigation;
    private String check;
    private String function;
    private String stride;
    private String detection_logic;
    private String risk_assessment;
    private String false_positives;
    private boolean model_failure_possible_reason;
    private int cwe;
    private Map<String, IdentifiedRisk> risks_identified;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImpact() {
        return impact;
    }

    public String getAsvs() {
        return asvs;
    }

    public String getCheat_sheet() {
        return cheat_sheet;
    }

    public String getAction() {
        return action;
    }

    public String getMitigation() {
        return mitigation;
    }

    public String getCheck() {
        return check;
    }

    public String getFunction() {
        return function;
    }

    public String getStride() {
        return stride;
    }

    public String getDetection_logic() {
        return detection_logic;
    }

    public String getRisk_assessment() {
        return risk_assessment;
    }

    public String getFalse_positives() {
        return false_positives;
    }

    public boolean isModel_failure_possible_reason() {
        return model_failure_possible_reason;
    }

    public int getCwe() {
        return cwe;
    }

    public Map<String, IdentifiedRisk> getRisks_identified() {
        return risks_identified;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public void setAsvs(String asvs) {
        this.asvs = asvs;
    }

    public void setCheat_sheet(String cheat_sheet) {
        this.cheat_sheet = cheat_sheet;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setStride(String stride) {
        this.stride = stride;
    }

    public void setDetection_logic(String detection_logic) {
        this.detection_logic = detection_logic;
    }

    public void setRisk_assessment(String risk_assessment) {
        this.risk_assessment = risk_assessment;
    }

    public void setFalse_positives(String false_positives) {
        this.false_positives = false_positives;
    }

    public void setModel_failure_possible_reason(boolean model_failure_possible_reason) {
        this.model_failure_possible_reason = model_failure_possible_reason;
    }

    public void setCwe(int cwe) {
        this.cwe = cwe;
    }

    public void setRisks_identified(Map<String, IdentifiedRisk> risks_identified) {
        this.risks_identified = risks_identified;
    }

}
