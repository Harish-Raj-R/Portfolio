package com.harishraj.portfolio.model;

import java.time.LocalDateTime;

public class CivicServiceRequest {
    private String requestId;
    private String citizenName;
    private String department; // "WATER_SUPPLY", "STREET_LIGHTS", "ROAD_REPAIR", "WASTE_MANAGEMENT", "HEALTH_SANITATION"
    private String title;
    private String description;
    private String priority; // "LOW", "MEDIUM", "HIGH", "CRITICAL"
    private String status; // "SUBMITTED", "IN_REVIEW", "ASSIGNED", "IN_PROGRESS", "RESOLVED"
    private String assignedOfficer;
    private String gatewayTraceId;
    private String microserviceNode;
    private LocalDateTime timestamp;

    public CivicServiceRequest() {
        this.timestamp = LocalDateTime.now();
    }

    public CivicServiceRequest(String requestId, String citizenName, String department, String title,
                               String description, String priority, String status, String assignedOfficer,
                               String gatewayTraceId, String microserviceNode) {
        this.requestId = requestId;
        this.citizenName = citizenName;
        this.department = department;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.assignedOfficer = assignedOfficer;
        this.gatewayTraceId = gatewayTraceId;
        this.microserviceNode = microserviceNode;
        this.timestamp = LocalDateTime.now();
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getCitizenName() { return citizenName; }
    public void setCitizenName(String citizenName) { this.citizenName = citizenName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedOfficer() { return assignedOfficer; }
    public void setAssignedOfficer(String assignedOfficer) { this.assignedOfficer = assignedOfficer; }

    public String getGatewayTraceId() { return gatewayTraceId; }
    public void setGatewayTraceId(String gatewayTraceId) { this.gatewayTraceId = gatewayTraceId; }

    public String getMicroserviceNode() { return microserviceNode; }
    public void setMicroserviceNode(String microserviceNode) { this.microserviceNode = microserviceNode; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
