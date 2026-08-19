package com.harishraj.portfolio.model;

import java.util.List;

public class Experience {
    private String role;
    private String organization;
    private String location;
    private String duration;
    private String type; // "INTERNSHIP" or "LEADERSHIP"
    private String tag;
    private List<String> bulletPoints;
    private List<String> technologies;

    public Experience() {}

    public Experience(String role, String organization, String location, String duration,
                      String type, String tag, List<String> bulletPoints, List<String> technologies) {
        this.role = role;
        this.organization = organization;
        this.location = location;
        this.duration = duration;
        this.type = type;
        this.tag = tag;
        this.bulletPoints = bulletPoints;
        this.technologies = technologies;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }

    public List<String> getBulletPoints() { return bulletPoints; }
    public void setBulletPoints(List<String> bulletPoints) { this.bulletPoints = bulletPoints; }

    public List<String> getTechnologies() { return technologies; }
    public void setTechnologies(List<String> technologies) { this.technologies = technologies; }
}
