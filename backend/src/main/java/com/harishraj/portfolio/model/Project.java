package com.harishraj.portfolio.model;

import java.util.List;

public class Project {
    private String id;
    private String title;
    private String subtitle;
    private String category;
    private String description;
    private List<String> bulletPoints;
    private List<String> techStack;
    private String badge;
    private String fundingInfo;
    private String githubUrl;
    private String liveDemoType; // "CIVIC_DESK" or "AGRI_APP" or "EXTERNAL"
    private boolean featured;

    public Project() {}

    public Project(String id, String title, String subtitle, String category, String description,
                   List<String> bulletPoints, List<String> techStack, String badge,
                   String fundingInfo, String githubUrl, String liveDemoType, boolean featured) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.description = description;
        this.bulletPoints = bulletPoints;
        this.techStack = techStack;
        this.badge = badge;
        this.fundingInfo = fundingInfo;
        this.githubUrl = githubUrl;
        this.liveDemoType = liveDemoType;
        this.featured = featured;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getBulletPoints() { return bulletPoints; }
    public void setBulletPoints(List<String> bulletPoints) { this.bulletPoints = bulletPoints; }

    public List<String> getTechStack() { return techStack; }
    public void setTechStack(List<String> techStack) { this.techStack = techStack; }

    public String getBadge() { return badge; }
    public void setBadge(String badge) { this.badge = badge; }

    public String getFundingInfo() { return fundingInfo; }
    public void setFundingInfo(String fundingInfo) { this.fundingInfo = fundingInfo; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getLiveDemoType() { return liveDemoType; }
    public void setLiveDemoType(String liveDemoType) { this.liveDemoType = liveDemoType; }

    public boolean isFeatured() { return featured; }
    public void setFeatured(boolean featured) { this.featured = featured; }
}
