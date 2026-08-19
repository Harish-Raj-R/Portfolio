package com.harishraj.portfolio.model;

public class Achievement {
    private String title;
    private String rank;
    private String event;
    private String year;
    private String prize;
    private String description;
    private String badgeColor; // e.g. "amber", "emerald", "cyan", "purple"

    public Achievement() {}

    public Achievement(String title, String rank, String event, String year, String prize, String description, String badgeColor) {
        this.title = title;
        this.rank = rank;
        this.event = event;
        this.year = year;
        this.prize = prize;
        this.description = description;
        this.badgeColor = badgeColor;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getPrize() { return prize; }
    public void setPrize(String prize) { this.prize = prize; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBadgeColor() { return badgeColor; }
    public void setBadgeColor(String badgeColor) { this.badgeColor = badgeColor; }
}
