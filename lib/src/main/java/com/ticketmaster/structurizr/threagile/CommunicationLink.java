package com.ticketmaster.structurizr.threagile;

public class CommunicationLink {
    private String target;
    private String description;
    private String protocol;
    private String authentication;
    private String authorization;
    private String[] tags;
    private boolean vpn;
    private boolean ip_filtered;
    private boolean readonly;
    private String usage;
    private String[] data_assets_sent;
    private String[] data_assets_received;

    public String getTarget() {
        return target;
    }

    public String getDescription() {
        return description;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getAuthentication() {
        return authentication;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String[] getTags() {
        return tags;
    }

    public boolean getVpn() {
        return vpn;
    }

    public boolean getIp_filtered() {
        return ip_filtered;
    }

    public boolean getReadonly() {
        return readonly;
    }

    public String getUsage() {
        return usage;
    }

    public String[] getData_assets_sent() {
        return data_assets_sent;
    }

    public String[] getData_assets_received() {
        return data_assets_received;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setVpn(boolean vpn) {
        this.vpn = vpn;
    }

    public void setIp_filtered(boolean ip_filtered) {
        this.ip_filtered = ip_filtered;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setData_assets_sent(String[] data_assets_sent) {
        this.data_assets_sent = data_assets_sent;
    }

    public void setData_assets_received(String[] data_assets_received) {
        this.data_assets_received = data_assets_received;
    }

}
