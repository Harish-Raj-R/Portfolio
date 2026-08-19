package com.harishraj.portfolio.controller;

import com.harishraj.portfolio.model.*;
import com.harishraj.portfolio.service.PortfolioDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioDataService portfolioDataService;

    public PortfolioController(PortfolioDataService portfolioDataService) {
        this.portfolioDataService = portfolioDataService;
    }

    @GetMapping("/profile")
    public ResponseEntity<Profile> getProfile() {
        return ResponseEntity.ok(portfolioDataService.getProfile());
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok(portfolioDataService.getProjects());
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        return portfolioDataService.getProjects().stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/experience")
    public ResponseEntity<List<Experience>> getExperience() {
        return ResponseEntity.ok(portfolioDataService.getExperiences());
    }

    @GetMapping("/skills")
    public ResponseEntity<List<SkillCategory>> getSkills() {
        return ResponseEntity.ok(portfolioDataService.getSkillCategories());
    }

    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAchievements() {
        return ResponseEntity.ok(portfolioDataService.getAchievements());
    }

    @GetMapping("/education")
    public ResponseEntity<List<Education>> getEducation() {
        return ResponseEntity.ok(portfolioDataService.getEducation());
    }

    @GetMapping("/certifications")
    public ResponseEntity<List<String>> getCertifications() {
        return ResponseEntity.ok(portfolioDataService.getCertifications());
    }

    @GetMapping("/overview")
    public ResponseEntity<Map<String, Object>> getFullOverview() {
        Map<String, Object> map = new HashMap<>();
        map.put("profile", portfolioDataService.getProfile());
        map.put("projects", portfolioDataService.getProjects());
        map.put("experience", portfolioDataService.getExperiences());
        map.put("skills", portfolioDataService.getSkillCategories());
        map.put("achievements", portfolioDataService.getAchievements());
        map.put("education", portfolioDataService.getEducation());
        map.put("certifications", portfolioDataService.getCertifications());
        map.put("systemStatus", "OPERATIONAL");
        return ResponseEntity.ok(map);
    }
}
