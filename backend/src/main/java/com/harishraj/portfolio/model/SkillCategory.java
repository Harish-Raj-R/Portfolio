package com.harishraj.portfolio.model;

import java.util.List;

public class SkillCategory {
    private String category;
    private String icon;
    private String description;
    private List<SkillItem> skills;

    public SkillCategory() {}

    public SkillCategory(String category, String icon, String description, List<SkillItem> skills) {
        this.category = category;
        this.icon = icon;
        this.description = description;
        this.skills = skills;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<SkillItem> getSkills() { return skills; }
    public void setSkills(List<SkillItem> skills) { this.skills = skills; }

    public static class SkillItem {
        private String name;
        private int level; // 1-100
        private String tag; // "Core", "Expert", "Proficient", "Familiar"

        public SkillItem() {}

        public SkillItem(String name, int level, String tag) {
            this.name = name;
            this.level = level;
            this.tag = tag;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getLevel() { return level; }
        public void setLevel(int level) { this.level = level; }

        public String getTag() { return tag; }
        public void setTag(String tag) { this.tag = tag; }
    }
}
