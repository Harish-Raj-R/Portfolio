# Harish Raj R - Full-Stack Interactive Portfolio
**Angular 19 + Java 21 / Spring Boot 3 Microservices Platform**

A high-performance, visually animated, interactive developer portfolio engineered to showcase **Harish Raj R**'s enterprise internship experience at **Cognizant**, microservice architecture mastery, smart farming IoT innovation funded by **Unnat Bharat Abhiyan**, hackathon championships, and developer community leadership.

---

## 🌟 Key Features & Interactive Demos

1. **Cyber-Modern Visuals & Interactive Particle Canvas**:
   - Particle engine with dynamic cursor gravity & physics.
   - Dynamic typewriter roles & glowing cyber glassmorphism cards.
   - Interactive Web Audio synth audio effects with mute toggle.

2. **Live CivicDesk Microservices Simulation (Cognizant Project)**:
   - **Service Request Tracker**: Submit real-time citizen grievance tickets via simulated API Gateway routing with distributed trace IDs.
   - **Workflow Status Transitions**: Simulate ticket lifecycles (`SUBMITTED` ➔ `IN_PROGRESS` ➔ `RESOLVED`).
   - **Netflix Eureka Service Registry**: View live health status of 10 distributed microservice nodes.
   - **Spring Security & JWT**: Generate and inspect signed HMAC-SHA256 Bearer tokens.
   - **RxJS Asynchronous Alerts**: Real-time notification streams.

3. **AI-Driven Smart Agriculture Simulator (Unnat Bharat Abhiyan 60k INR Grant)**:
   - Interactive telemetry sliders (Nitrogen, Phosphorus, Potassium, Moisture, Soil pH, Temperature).
   - Real-time crop recommendations, fertilizer protocols, irrigation schedules, and predicted yields.
   - Multilingual support for localized advisory in English, Tamil, Hindi, and Telugu.
   - Quick one-click soil presets (Delta Paddy, Arid Millet, Fertile Maize, Coastal Groundnut).

4. **Integrated Retro-Futuristic Terminal (CLI)**:
   - Type commands like `help`, `about`, `skills`, `projects`, `cognizant`, `trophies`, `contact`, `matrix`, `sudo hire`.

5. **Trophy Vault & Hackathons**:
   - Interactive cards for **Unfold Hackathon '23 ($300 USD Winner)**, **Smart India Hackathon '24**, **SSN VIVID 8.0**, **Kurukshetra '24 (Anna University)**, and **NPTEL Elite certifications** with celebratory confetti animations.

6. **Full-Stack Spring Boot 3 REST API Backend**:
   - RESTful endpoints for profile, skills, timeline, real-time microservices simulation, and contact messaging.

---

## 🚀 How to Run the Project

### Prerequisites
- **Node.js**: v20+ / v22+
- **Java**: JDK 21+ / JDK 23
- **Maven**: 3.8+ (or Maven wrapper)

---

### Step 1: Start the Java Spring Boot Backend
Open a terminal in the `backend/` directory:
```bash
cd backend
mvn spring-boot:run
```
> The backend server will launch at `http://localhost:8080` with REST endpoints under `/api/*`.

---

### Step 2: Start the Angular Frontend
Open a new terminal in the `frontend/` directory:
```bash
cd frontend
npm start
```
> The frontend application will launch at `http://localhost:4200`.

---

## 📂 Project Structure

```
portfolio/
├── backend/                               # Java Spring Boot REST API
│   ├── pom.xml
│   └── src/main/java/com/harishraj/portfolio/
│       ├── PortfolioApplication.java     # Application Main
│       ├── config/CorsConfig.java        # Cross-Origin Resource Sharing
│       ├── controller/                   # REST Controllers
│       │   ├── PortfolioController.java
│       │   ├── CivicDeskController.java
│       │   ├── AgriController.java
│       │   └── ContactController.java
│       ├── model/                        # DTOs & Domain Models
│       └── service/                      # Business & Simulation Logic
│
└── frontend/                              # Angular 19 Standalone Application
    ├── package.json
    ├── angular.json
    └── src/
        ├── index.html
        ├── styles.scss                   # Global Cyber Design System
        └── app/
            ├── app.component.ts
            ├── models/portfolio.model.ts
            ├── services/                 # Portfolio & Audio Services
            └── components/
                ├── navbar/               # Glass Navigation & Sound Switch
                ├── hero/                 # Particle Canvas & Role Typist
                ├── about/                # Education (RMKEC 8.47) & TOEFL C1
                ├── experience/           # Cognizant & Namma Flutter Lead
                ├── projects/             # CivicDesk & AI Agri Project Showcase
                ├── civic-demo/           # Live Microservices Simulator
                ├── agri-demo/            # AI Crop Recommendation Engine
                ├── skills/               # Interactive Skill Bars & Matrix
                ├── achievements/         # Hackathon Trophy Vault
                ├── terminal/             # Interactive CLI Terminal
                ├── contact/              # Recruiter Dispatch Form
                └── footer/               # Back to top & Quick links
```

---

## 👨‍💻 Candidate Profile

- **Name**: Harish Raj R
- **Role**: Full Stack Java Developer & Angular Engineer
- **Email**: itsharishrajr@gmail.com
- **Phone**: +91 8778726685
- **LinkedIn**: [linkedin.com/in/harish-raj-r-](https://linkedin.com/in/harish-raj-r-)
- **GitHub**: [github.com/Harish-Raj-R](https://github.com/Harish-Raj-R)
- **Education**: B.E in Electronics & Communication Engineering, R.M.K Engineering College (CGPA: 8.47 / 10)
- **Language**: TOEFL ITP Level 1: 553/677 (Speaking: 68 - C1 CEFR Level)
