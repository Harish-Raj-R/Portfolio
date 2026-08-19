package com.harishraj.portfolio.model;

import java.time.LocalDateTime;

public class CivicNotification {
    private String id;
    private String recipientRole; // "CITIZEN", "OFFICER", "ADMIN"
    private String message;
    private String type; // "STATUS_UPDATE", "ALERT", "DISPATCH"
    private String requestId;
    private LocalDateTime timestamp;

    public CivicNotification() {
        this.timestamp = LocalDateTime.now();
    }

    public CivicNotification(String id, String recipientRole, String message, String type, String requestId) {
        this.id = id;
        this.recipientRole = recipientRole;
        this.message = message;
        this.type = type;
        this.requestId = requestId;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRecipientRole() { return recipientRole; }
    public void setRecipientRole(String recipientRole) { this.recipientRole = recipientRole; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
