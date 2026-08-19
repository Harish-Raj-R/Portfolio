package com.harishraj.portfolio.controller;

import com.harishraj.portfolio.model.AgriRecommendation;
import com.harishraj.portfolio.model.AgriTelemetry;
import com.harishraj.portfolio.service.AgriRecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/agri")
public class AgriController {

    private final AgriRecommendationService agriService;

    public AgriController(AgriRecommendationService agriService) {
        this.agriService = agriService;
    }

    @PostMapping("/recommend")
    public ResponseEntity<AgriRecommendation> getRecommendation(@RequestBody AgriTelemetry telemetry) {
        return ResponseEntity.ok(agriService.predictOptimalCrop(telemetry));
    }

    @GetMapping("/telemetry/presets")
    public ResponseEntity<Map<String, AgriTelemetry>> getPresets() {
        AgriTelemetry deltaPaddy = new AgriTelemetry(90, 55, 65, 78, 6.5, 29.5, 82, "Clay Loam", "en");
        AgriTelemetry aridMillet = new AgriTelemetry(35, 25, 30, 22, 7.8, 34.0, 40, "Sandy", "en");
        AgriTelemetry fertileMaize = new AgriTelemetry(75, 48, 50, 55, 6.8, 27.0, 65, "Loamy", "en");
        AgriTelemetry coastalGroundnut = new AgriTelemetry(40, 60, 45, 38, 7.2, 31.0, 58, "Red Sandy", "en");

        return ResponseEntity.ok(Map.of(
                "deltaPaddy", deltaPaddy,
                "aridMillet", aridMillet,
                "fertileMaize", fertileMaize,
                "coastalGroundnut", coastalGroundnut
        ));
    }
}
