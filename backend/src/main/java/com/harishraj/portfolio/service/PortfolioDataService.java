package com.harishraj.portfolio.service;

import com.harishraj.portfolio.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PortfolioDataService {

    public Profile getProfile() {
        return new Profile(
                "Harish Raj R",
                "Full Stack Java Developer & Angular Engineer",
                "Building high-scale Microservices with Spring Boot & crafting ultra-fluid, responsive Web UIs with Angular & RxJS",
                "itsharishrajr@gmail.com",
                "+91 8778726685",
                "https://linkedin.com/in/harish-raj-r-",
                "https://github.com/Harish-Raj-R",
                "Chennai, India",
                "Full Stack Developer with hands-on enterprise internship experience at Cognizant building end-to-end Spring Boot microservices, Spring Security JWT authentication, and reactive Angular UIs with RxJS. Passionate community leader directing 10+ developer hackathons for 5,000+ members, hackathon winner, and funded smart agriculture innovator.",
                Arrays.asList(
                        "Cognizant Full Stack Java & Angular Intern",
                        "Secured 60,000 INR funding for AI Agriculture Project from Unnat Bharat Abhiyan",
                        "Unfold Hackathon '23 2nd Place Winner ($300 USD)",
                        "Honors in VLSI & National Hackathon Finalist",
                        "TOEFL ITP Level 1: 553/677 (Speaking: 68 - C1 Level)",
                        "B.E Electronics & Communication Engineering (CGPA: 8.47 / 10)"
                ),
                "553/677 (Speaking: 68 - C1 Level)"
        );
    }

    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();

        Project civicDesk = new Project(
                "civicdesk",
                "CivicDesk – Municipal Engagement & Operations Portal",
                "Enterprise Distributed Microservices Platform for Municipal Governance",
                "Enterprise Full Stack / Microservices",
                "Architected and implemented enterprise-grade Service Request Management and real-time Notification modules. One of 10 microservices registered via Eureka Service Discovery, secured with Spring Security JWT tokens, routed through an API Gateway, and powered by reactive Angular Material frontend with RxJS.",
                Arrays.asList(
                        "Engineered the Service Request Management module using Spring Boot, Spring Security, and JWT, exposing RESTful APIs for request logging, status lifecycle, and document verification.",
                        "Integrated with Eureka Service Registry and Netflix Zuul / Spring Cloud Gateway across 10 distributed microservice nodes.",
                        "Developed real-time Notification dispatch module using Spring Boot and MySQL for automated alerts to citizens and municipal officers.",
                        "Designed responsive Angular 19 UI screens utilizing Angular Material, reactive forms, and RxJS observables for seamless asynchronous data streaming."
                ),
                Arrays.asList("Java", "Spring Boot", "Spring Security", "Spring Data JPA", "JWT", "MySQL", "Microservices", "Eureka", "API Gateway", "Angular", "RxJS", "Angular Material"),
                "Cognizant Internship Project",
                "Enterprise Multi-Service Architecture",
                "https://github.com/Harish-Raj-R",
                "CIVIC_DESK",
                true
        );

        Project agriApp = new Project(
                "ai-agri-app",
                "AI-Driven Agriculture App: Multilingual Recommendation Engine",
                "Personalized Smart Farming & Crop Advisory System with IoT Telemetry",
                "AI / IoT & Web",
                "Engineered a multilingual smart farming application featuring an intelligent recommendation engine that analyzes real-time soil NPK, moisture, and microclimate telemetry to deliver personalized crop and fertilizer advisories. Secured 60,000 INR grant from Unnat Bharat Abhiyan.",
                Arrays.asList(
                        "Secured 60k INR government funding from Unnat Bharat Abhiyan for impactful results in smart agricultural modernization.",
                        "Built personalized ML recommendation algorithm matching soil parameters (N, P, K, pH, moisture, temp) to optimal crop yields.",
                        "Led end-to-end UI/UX architecture and integrated hardware sensors with Arduino, Blynk IoT, and cloud telemetry.",
                        "Crafted multilingual localized interface supporting regional languages for accessible farming assistance."
                ),
                Arrays.asList("Angular", "TypeScript", "Arduino", "AI/ML", "Blynk IoT", "Sensors (NPK/DHT)", "Figma", "Spring Boot REST"),
                "60,000 INR Funded (Unnat Bharat Abhiyan)",
                "Govt Funded Project (Unnat Bharat Abhiyan)",
                "https://github.com/Harish-Raj-R",
                "AGRI_APP",
                true
        );

        projects.add(civicDesk);
        projects.add(agriApp);
        return projects;
    }

    public List<Experience> getExperiences() {
        List<Experience> list = new ArrayList<>();

        Experience cognizant = new Experience(
                "Full Stack Java Developer Intern (Angular)",
                "Cognizant",
                "Chennai, India",
                "April 2026 – August 2026",
                "INTERNSHIP",
                "Industry Experience",
                Arrays.asList(
                        "Built the Service Request Management and Notification modules end-to-end using Spring Boot, Spring Security, Spring Data JPA, and MySQL.",
                        "Designed and exposed JWT-secured RESTful APIs routed through an API Gateway with Eureka Service Discovery for fault-tolerant microservice communication.",
                        "Developed dynamic, accessible Angular Material UI screens consuming backend REST APIs and leveraging RxJS for reactive state and data streaming.",
                        "Collaborated actively in an Agile/Scrum cross-functional team utilizing Git for version control, Postman for comprehensive API testing, and CI/CD pipelines."
                ),
                Arrays.asList("Java", "Spring Boot", "Spring Security", "Spring Data JPA", "Angular", "RxJS", "Angular Material", "JWT", "MySQL", "API Gateway", "Eureka", "Git", "Postman", "Agile")
        );

        Experience devGuild = new Experience(
                "Community Lead & Technical Organizer",
                "Chennai Developers Guild / Tech Community",
                "Chennai, India",
                "March 2024 – Present",
                "LEADERSHIP",
                "Community Leadership",
                Arrays.asList(
                        "Organized and directed 10+ high-impact hackathons, coding workshops, and developer technical sessions.",
                        "Mentored emerging engineers in full-stack web development, microservice concepts, and software architecture.",
                        "Scaled active developer community engagement across Chennai."
                ),
                Arrays.asList("Community Leadership", "Technical Mentorship", "Hackathon Direction", "Developer Ecosystems")
        );

        Experience coord = new Experience(
                "Technical Coordinator",
                "Student Developer & Innovation Cell",
                "Chennai, India",
                "August 2024 – 2026",
                "LEADERSHIP",
                "Campus Leadership",
                Arrays.asList(
                        "Conducted hands-on technical workshops on modern web architecture and Java backend systems.",
                        "Facilitated collaborative hackathons and peer coding challenges."
                ),
                Arrays.asList("Workshop Facilitation", "Web Architecture", "Java Systems", "Technical Coordination")
        );

        list.add(cognizant);
        list.add(devGuild);
        list.add(coord);
        return list;
    }

    public List<SkillCategory> getSkillCategories() {
        List<SkillCategory> categories = new ArrayList<>();

        categories.add(new SkillCategory(
                "Backend & Java Ecosystem",
                "server",
                "Enterprise Java, Spring Boot microservices, security, and persistence",
                Arrays.asList(
                        new SkillCategory.SkillItem("Java", 95, "Core"),
                        new SkillCategory.SkillItem("Spring Boot", 92, "Core"),
                        new SkillCategory.SkillItem("Spring Security (JWT)", 88, "Core"),
                        new SkillCategory.SkillItem("Spring Data JPA / Hibernate", 90, "Core"),
                        new SkillCategory.SkillItem("Microservices Architecture", 88, "Core"),
                        new SkillCategory.SkillItem("Eureka Service Discovery", 85, "Proficient"),
                        new SkillCategory.SkillItem("API Gateway Routing", 86, "Proficient"),
                        new SkillCategory.SkillItem("RESTful API Design", 94, "Expert")
                )
        ));

        categories.add(new SkillCategory(
                "Frontend & Web Technologies",
                "layout",
                "Modern Single Page Applications, reactive streams, and component design",
                Arrays.asList(
                        new SkillCategory.SkillItem("Angular (v17/18/19)", 92, "Core"),
                        new SkillCategory.SkillItem("TypeScript / JavaScript", 90, "Core"),
                        new SkillCategory.SkillItem("RxJS Observables & Reactive State", 88, "Core"),
                        new SkillCategory.SkillItem("Angular Material & CDK", 90, "Expert"),
                        new SkillCategory.SkillItem("Tailwind CSS / SCSS / Flexbox", 92, "Expert"),
                        new SkillCategory.SkillItem("HTML5 / Modern DOM APIs", 95, "Core")
                )
        ));

        categories.add(new SkillCategory(
                "Databases, Cloud & Dev Tools",
                "database",
                "Relational databases, API testing, version control, and design systems",
                Arrays.asList(
                        new SkillCategory.SkillItem("MySQL / Relational Modeling", 88, "Core"),
                        new SkillCategory.SkillItem("SQL Query Optimization", 86, "Proficient"),
                        new SkillCategory.SkillItem("Git & GitHub Workflow", 92, "Expert"),
                        new SkillCategory.SkillItem("Postman / API Automation", 90, "Expert"),
                        new SkillCategory.SkillItem("VS Code / IntelliJ IDEA", 92, "Proficient"),
                        new SkillCategory.SkillItem("Figma UI/UX Prototyping", 85, "Proficient")
                )
        ));

        categories.add(new SkillCategory(
                "Hardware, VLSI & Embedded Systems",
                "cpu",
                "VLSI architectures, digital system design, and IoT telemetry",
                Arrays.asList(
                        new SkillCategory.SkillItem("VLSI Design & Architecture", 90, "Core"),
                        new SkillCategory.SkillItem("System Verilog / Quartus / Xilinx", 85, "Proficient"),
                        new SkillCategory.SkillItem("Arduino / IoT Sensors (Blynk)", 84, "Proficient"),
                        new SkillCategory.SkillItem("MicroWind / PSpice / LTspice", 80, "Proficient")
                )
        ));

        return categories;
    }

    public List<Achievement> getAchievements() {
        return Arrays.asList(
                new Achievement(
                        "Unfold Hackathon '23",
                        "2nd Place Winner",
                        "Global Web3 & Systems Hackathon",
                        "2023",
                        "$300 USD Cash Prize",
                        "Secured 2nd place among hundreds of participants, presenting high-performance decentralized and distributed architecture.",
                        "amber"
                ),
                new Achievement(
                        "Smart India Hackathon (SIH '24)",
                        "6th Place (Internal Level)",
                        "Smart India Hackathon 2024",
                        "2024",
                        "National Stage Finalist Track",
                        "Ranked 6th in the competitive internal round of India's largest nationwide open innovation model.",
                        "emerald"
                ),
                new Achievement(
                        "SSN VIVID 8.0 National Project Expo",
                        "3rd Place",
                        "SSN College of Engineering",
                        "2024",
                        "Project Excellence Award",
                        "Awarded 3rd place in state-level project showcase for smart AI-driven agriculture recommendation system.",
                        "cyan"
                ),
                new Achievement(
                        "Kurukshetra '24 (Anna University)",
                        "2nd Place",
                        "Kurukshetra International Techno-Management Fest",
                        "2024",
                        "Paper Presentation Laureate",
                        "Won 2nd place in Paper Presentation presenting research on AI algorithms and IoT sensor telemetry.",
                        "purple"
                ),
                new Achievement(
                        "Sri Venkateshwara College Paper Presentation",
                        "1st Place",
                        "National Technical Symposium",
                        "2024",
                        "1st Prize Winner",
                        "Clinched 1st place for technical rigor and presentation clarity in smart embedded systems.",
                        "amber"
                ),
                new Achievement(
                        "RMKEC Idea Contest '23",
                        "2nd Place",
                        "RMK Engineering College Innovation Cell",
                        "2023",
                        "Innovation Silver Award",
                        "Recognized for innovative municipal and smart city civic governance system.",
                        "emerald"
                ),
                new Achievement(
                        "Startup Cafe '24",
                        "Pre-Finalist",
                        "Entrepreneurship & Venture Summit",
                        "2024",
                        "Venture Pitch Recognition",
                        "Reached the Pre-Final stage demonstrating strong product-market fit, business acumen, and scalable architecture.",
                        "cyan"
                )
        );
    }

    public List<Education> getEducation() {
        return Arrays.asList(
                new Education(
                        "R.M.K Engineering College",
                        "Bachelor of Engineering (B.E)",
                        "Electronics and Communication Engineering",
                        "2022 – 2026",
                        "CGPA: 8.47 / 10",
                        "Chennai, India",
                        Arrays.asList(
                                "Distinction academic record (CGPA 8.47)",
                                "Active leader in coding clubs and technical symposiums",
                                "Honors in VLSI"
                        )
                ),
                new Education(
                        "Sri Sankara Vidya Kendra Higher Secondary School",
                        "Higher Secondary Certificate (12th & 10th Standard)",
                        "Computer Science & Mathematics Stream",
                        "2019 – 2022",
                        "12th: 93.0% | 10th: 83.4%",
                        "Chennai, India",
                        Arrays.asList(
                                "Top percentile score in 12th Board examinations (93%)",
                                "Foundational training in computer programming and mathematics"
                        )
                )
        );
    }

    public List<String> getCertifications() {
        return Arrays.asList(
                "NPTEL: Introduction to IoT (Elite)",
                "NPTEL: Joy of Computing Using Python (Elite + Silver Medal)",
                "NPTEL: Python for Data Science (Elite)",
                "NPTEL: System Design Through Verilog",
                "TOEFL ITP Level 1: Score 553/677 (Speaking: 68 - C1 CEFR Level)"
        );
    }
}
