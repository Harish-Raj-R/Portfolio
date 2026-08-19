package com.harishraj.portfolio.service;

import com.harishraj.portfolio.model.CivicNotification;
import com.harishraj.portfolio.model.CivicServiceRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CivicDeskSimulationService {

    private final List<CivicServiceRequest> requests = new CopyOnWriteArrayList<>();
    private final List<CivicNotification> notifications = new CopyOnWriteArrayList<>();
    private final Map<String, Object> eurekaRegistry = new ConcurrentHashMap<>();

    public CivicDeskSimulationService() {
        seedInitialData();
    }

    private void seedInitialData() {
        // Mock Eureka Registry (10 Microservices from Cognizant Project)
        eurekaRegistry.put("CIVIC-API-GATEWAY", Map.of("port", 8080, "status", "UP", "instances", 2, "routePrefix", "/api/v1/*"));
        eurekaRegistry.put("SERVICE-REQUEST-MGMT", Map.of("port", 8081, "status", "UP", "instances", 3, "db", "MySQL-Cluster"));
        eurekaRegistry.put("NOTIFICATION-SERVICE", Map.of("port", 8082, "status", "UP", "instances", 2, "async", "RxJS/SSE"));
        eurekaRegistry.put("AUTH-JWT-SECURITY", Map.of("port", 8083, "status", "UP", "instances", 2, "algo", "HMAC-SHA256"));
        eurekaRegistry.put("CITIZEN-IDENTITY-SVC", Map.of("port", 8084, "status", "UP", "instances", 1, "role", "KYC"));
        eurekaRegistry.put("OFFICER-DISPATCH-SVC", Map.of("port", 8085, "status", "UP", "instances", 2, "role", "Dispatcher"));
        eurekaRegistry.put("DOCUMENT-REVIEW-SVC", Map.of("port", 8086, "status", "UP", "instances", 1, "role", "Verification"));
        eurekaRegistry.put("GEO-MAPPING-SERVICE", Map.of("port", 8087, "status", "UP", "instances", 2, "role", "GIS"));
        eurekaRegistry.put("ANALYTICS-DASH-SVC", Map.of("port", 8088, "status", "UP", "instances", 1, "role", "Metrics"));
        eurekaRegistry.put("EUREKA-SERVER-CORE", Map.of("port", 8761, "status", "UP", "mode", "STANDALONE"));

        // Seed initial requests
        CivicServiceRequest req1 = new CivicServiceRequest(
                "CR-2026-8941",
                "Arun Kumar",
                "WATER_SUPPLY",
                "Low water pressure in Ward 14 pipeline",
                "Water pressure dropped significantly since Monday morning. Multiple households affected.",
                "HIGH",
                "IN_PROGRESS",
                "Officer Rajesh V (Zone 3)",
                "gw-trace-8f92a10c",
                "SRV-REQ-NODE-02"
        );

        CivicServiceRequest req2 = new CivicServiceRequest(
                "CR-2026-8942",
                "Meenakshi S",
                "STREET_LIGHTS",
                "LED Streetlight flickering at Main Junction",
                "Light pole #42 on Anna Salai 4th Cross is malfunctioning intermittently at night.",
                "MEDIUM",
                "RESOLVED",
                "Officer Kavitha M (Electrical Div)",
                "gw-trace-3a71bc9d",
                "SRV-REQ-NODE-01"
        );

        CivicServiceRequest req3 = new CivicServiceRequest(
                "CR-2026-8943",
                "Ramesh Chandran",
                "ROAD_REPAIR",
                "Pothole repair needed near Metro Pillar 118",
                "Deep pothole causing vehicle congestion and minor two-wheeler skids during rains.",
                "CRITICAL",
                "ASSIGNED",
                "Officer Suresh Kumar (Civil Eng)",
                "gw-trace-9912ee44",
                "SRV-REQ-NODE-03"
        );

        requests.add(req1);
        requests.add(req2);
        requests.add(req3);

        notifications.add(new CivicNotification(
                UUID.randomUUID().toString().substring(0, 8),
                "CITIZEN",
                "Your service request CR-2026-8942 has been marked as RESOLVED by Officer Kavitha M.",
                "STATUS_UPDATE",
                "CR-2026-8942"
        ));
        notifications.add(new CivicNotification(
                UUID.randomUUID().toString().substring(0, 8),
                "OFFICER",
                "High priority request CR-2026-8943 dispatched to Civil Maintenance Team.",
                "DISPATCH",
                "CR-2026-8943"
        ));
    }

    public Map<String, Object> getEurekaRegistry() {
        return eurekaRegistry;
    }

    public List<CivicServiceRequest> getAllRequests() {
        return requests;
    }

    public CivicServiceRequest createRequest(CivicServiceRequest newRequest) {
        String reqId = "CR-2026-" + (1000 + requests.size() + new Random().nextInt(8999));
        newRequest.setRequestId(reqId);
        newRequest.setStatus("SUBMITTED");
        newRequest.setGatewayTraceId("gw-trace-" + UUID.randomUUID().toString().substring(0, 8));
        newRequest.setMicroserviceNode("SRV-REQ-NODE-" + (1 + new Random().nextInt(3)));

        if (newRequest.getPriority() == null || newRequest.getPriority().isBlank()) {
            newRequest.setPriority("MEDIUM");
        }

        requests.add(0, newRequest);

        // Emit real-time notification
        CivicNotification notif = new CivicNotification(
                UUID.randomUUID().toString().substring(0, 8),
                "CITIZEN",
                "Service Request " + reqId + " (" + newRequest.getTitle() + ") logged successfully via API Gateway.",
                "STATUS_UPDATE",
                reqId
        );
        notifications.add(0, notif);

        return newRequest;
    }

    public CivicServiceRequest updateStatus(String requestId, String newStatus, String officer) {
        for (CivicServiceRequest req : requests) {
            if (req.getRequestId().equalsIgnoreCase(requestId)) {
                req.setStatus(newStatus);
                if (officer != null && !officer.isBlank()) {
                    req.setAssignedOfficer(officer);
                }

                CivicNotification notif = new CivicNotification(
                        UUID.randomUUID().toString().substring(0, 8),
                        "CITIZEN",
                        "Update on " + req.getRequestId() + ": Status changed to " + newStatus + (officer != null ? " by " + officer : ""),
                        "STATUS_UPDATE",
                        req.getRequestId()
                );
                notifications.add(0, notif);
                return req;
            }
        }
        return null;
    }

    public List<CivicNotification> getNotifications() {
        return notifications;
    }

    public Map<String, Object> simulateJwtAuth(String username) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                Base64.getEncoder().encodeToString(("{\"sub\":\"" + username + "\",\"roles\":[\"ROLE_OFFICER\",\"ROLE_CITIZEN\"],\"iss\":\"CivicDesk-Auth-Service\",\"exp\":" + (System.currentTimeMillis() + 3600000) + "}").getBytes()) +
                ".s8f9d023fksm91024nmva921n4";
        return Map.of(
                "token", token,
                "tokenType", "Bearer",
                "expiresInSeconds", 3600,
                "username", username,
                "authenticatedVia", "Spring Security 6 + Eureka API Gateway",
                "authorities", List.of("ROLE_CITIZEN", "ROLE_OFFICER", "ROLE_INSPECTOR")
        );
    }
}
