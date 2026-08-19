package com.harishraj.portfolio.model;

import java.util.List;

public class Profile {
    private String name;
    private String title;
    private String tagLine;
    private String email;
    private String phone;
    private String linkedIn;
    private String github;
    private String location;
    private String summary;
    private List<String> highlights;
    private String toeflScore;

    public Profile() {}

    public Profile(String name, String title, String tagLine, String email, String phone,
                   String linkedIn, String github, String location, String summary,
                   List<String> highlights, String toeflScore) {
        this.name = name;
        this.title = title;
        this.tagLine = tagLine;
        this.email = email;
        this.phone = phone;
        this.linkedIn = linkedIn;
        this.github = github;
        this.location = location;
        this.summary = summary;
        this.highlights = highlights;
        this.toeflScore = toeflScore;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getTagLine() { return tagLine; }
    public void setTagLine(String tagLine) { this.tagLine = tagLine; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLinkedIn() { return linkedIn; }
    public void setLinkedIn(String linkedIn) { this.linkedIn = linkedIn; }

    public String getGithub() { return github; }
    public void setGithub(String github) { this.github = github; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public List<String> getHighlights() { return highlights; }
    public void setHighlights(List<String> highlights) { this.highlights = highlights; }

    public String getToeflScore() { return toeflScore; }
    public void setToeflScore(String toeflScore) { this.toeflScore = toeflScore; }
}
