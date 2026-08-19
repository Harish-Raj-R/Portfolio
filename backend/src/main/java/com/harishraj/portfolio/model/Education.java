package com.harishraj.portfolio.model;

import java.util.List;

public class Education {
    private String institution;
    private String degree;
    private String field;
    private String duration;
    private String score;
    private String location;
    private List<String> highlights;

    public Education() {}

    public Education(String institution, String degree, String field, String duration,
                     String score, String location, List<String> highlights) {
        this.institution = institution;
        this.degree = degree;
        this.field = field;
        this.duration = duration;
        this.score = score;
        this.location = location;
        this.highlights = highlights;
    }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<String> getHighlights() { return highlights; }
    public void setHighlights(List<String> highlights) { this.highlights = highlights; }
}
