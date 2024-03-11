package com.ticketmaster.structurizr.threagile;

public class RiskTracking {
    private String status;
    private String justification;
    private String ticket;
    private String date;
    private String checked_by;

    public String getStatus() {
        return status;
    }

    public String getJustification() {
        return justification;
    }

    public String getTicket() {
        return ticket;
    }

    public String getDate() {
        return date;
    }

    public String getChecked_by() {
        return checked_by;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setChecked_by(String checked_by) {
        this.checked_by = checked_by;
    }
}
