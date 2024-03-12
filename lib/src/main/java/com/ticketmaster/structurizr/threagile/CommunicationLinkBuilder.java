package com.ticketmaster.structurizr.threagile;

import com.structurizr.model.Relationship;

public class CommunicationLinkBuilder {
    private CommunicationLink communicationLink;

    public CommunicationLinkBuilder() {
        communicationLink = new CommunicationLink();
    }

    public CommunicationLinkBuilder From(Relationship relationship) {
        communicationLink.setDescription(relationship.getDescription());
        communicationLink.setProtocol(toThreagileProtocol(relationship.getTechnology()));
        return this;
    }

    public CommunicationLinkBuilder WithDefault() {
        communicationLink.setAuthentication("none");
        communicationLink.setAuthorization("none");
        communicationLink.setTags(new String[] {});
        communicationLink.setVpn(false);
        communicationLink.setIp_filtered(false);
        communicationLink.setReadonly(false);
        communicationLink.setUsage("business");
        communicationLink.setData_assets_sent(new String[] {});
        communicationLink.setData_assets_received(new String[] {});
        return this;
    }

    public CommunicationLinkBuilder WithTargetId(String targetId) {
        communicationLink.setTarget(targetId);
        return this;
    }

    public CommunicationLink Build() {
        return communicationLink;
    }
    
    private static String toThreagileProtocol(String technology) {
        if (technology == null) {
            return "http";
        }
        switch (technology.toLowerCase()) {
            case "mysql protocol/ssl":
                return "odbc-encrypted";
            case "relational database schema":
                return "odbc";
            case "i/o":
                return "local-file-access";
            case "wss/graphql":
                return "wss";
            case "":
            case "browser":
            case "tcp":
            case "http/browser":
            case "application/json":
            case "graphql":
                return "http";
            default:
                return technology.toLowerCase();
        }
    }
}
