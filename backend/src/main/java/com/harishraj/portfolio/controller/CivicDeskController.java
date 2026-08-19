package com.harishraj.portfolio.controller;

import com.harishraj.portfolio.model.CivicNotification;
import com.harishraj.portfolio.model.CivicServiceRequest;
import com.harishraj.portfolio.service.CivicDeskSimulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/civicdesk")
public class CivicDeskController {

    private final CivicDeskSimulationService civicService;

    public CivicDeskController(CivicDeskSimulationService civicService) {
        this.civicService = civicService;
    }

    @GetMapping("/eureka/registry")
    public ResponseEntity<Map<String, Object>> getEurekaRegistry() {
        return ResponseEntity.ok(civicService.getEurekaRegistry());
    }

    @GetMapping("/requests")
    public ResponseEntity<List<CivicServiceRequest>> getAllRequests() {
        return ResponseEntity.ok(civicService.getAllRequests());
    }

    @PostMapping("/requests")
    public ResponseEntity<CivicServiceRequest> createRequest(@RequestBody CivicServiceRequest request) {
        return ResponseEntity.ok(civicService.createRequest(request));
    }

    @PutMapping("/requests/{id}/status")
    public ResponseEntity<CivicServiceRequest> updateStatus(
            @PathVariable String id,
            @RequestBody Map<String, String> payload) {
        String status = payload.get("status");
        String officer = payload.get("officer");
        CivicServiceRequest updated = civicService.updateStatus(id, status, officer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<CivicNotification>> getNotifications() {
        return ResponseEntity.ok(civicService.getNotifications());
    }

    @PostMapping("/auth/simulate-jwt")
    public ResponseEntity<Map<String, Object>> simulateJwt(@RequestBody Map<String, String> payload) {
        String username = payload.getOrDefault("username", "officer.harishraj");
        return ResponseEntity.ok(civicService.simulateJwtAuth(username));
    }
}
