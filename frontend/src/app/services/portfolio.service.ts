import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, of } from 'rxjs';
import {
  Profile,
  Project,
  Experience,
  SkillCategory,
  Achievement,
  Education,
  CivicServiceRequest,
  CivicNotification,
  AgriTelemetry,
  AgriRecommendation,
  ContactMessage
} from '../models/portfolio.model';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api';

  // Fallback profile data
  private fallbackProfile: Profile = {
    name: 'Harish Raj R',
    title: 'Full Stack Java Developer & Angular Engineer',
    tagLine: 'Building resilient Spring Boot microservices & reactive Angular web applications.',
    email: 'itsharishrajr@gmail.com',
    phone: '+91 8778726685',
    linkedIn: 'https://linkedin.com/in/harish-raj-r-',
    github: 'https://github.com/Harish-Raj-R',
    location: 'Chennai, India',
    summary: 'Full Stack Developer with enterprise internship experience at Cognizant building end-to-end Spring Boot microservices, Spring Security JWT authentication, and reactive Angular UIs with RxJS. Passionate community leader directing 10+ developer hackathons for 5,000+ members, hackathon winner, and funded smart agriculture innovator.',
    highlights: [
      'Cognizant Full Stack Java & Angular Intern',
      'Secured 60,000 INR funding for AI Agriculture Project from Unnat Bharat Abhiyan',
      'Unfold Hackathon \'23 2nd Place Winner ($300 USD)',
      'Honors in VLSI & National Hackathon Finalist',
      'TOEFL ITP Level 1: 553/677 (Speaking: 68 - C1 Level)',
      'B.E Electronics & Communication Engineering (CGPA: 8.47 / 10)'
    ],
    toeflScore: '553/677 (Speaking: 68 - C1 Level)'
  };

  private fallbackProjects: Project[] = [
    {
      id: 'civicdesk',
      title: 'CivicDesk – Municipal Engagement & Operations Portal',
      subtitle: 'Enterprise Distributed Microservices Platform for Municipal Governance',
      category: 'Enterprise Full Stack / Microservices',
      description: 'Architected and implemented enterprise-grade Service Request Management and real-time Notification modules. One of 10 microservices registered via Eureka Service Discovery, secured with Spring Security JWT tokens, routed through an API Gateway, and powered by reactive Angular Material frontend with RxJS.',
      bulletPoints: [
        'Engineered the Service Request Management module using Spring Boot, Spring Security, and JWT, exposing RESTful APIs for request logging, status lifecycle, and document verification.',
        'Integrated with Eureka Service Registry and Netflix Zuul / Spring Cloud Gateway across 10 distributed microservice nodes.',
        'Developed real-time Notification dispatch module using Spring Boot and MySQL for automated alerts to citizens and municipal officers.',
        'Designed responsive Angular 19 UI screens utilizing Angular Material, reactive forms, and RxJS observables for seamless asynchronous data streaming.'
      ],
      techStack: ['Java', 'Spring Boot', 'Spring Security', 'Spring Data JPA', 'JWT', 'MySQL', 'Microservices', 'Eureka', 'API Gateway', 'Angular', 'RxJS', 'Angular Material'],
      badge: 'Cognizant Internship Project',
      fundingInfo: 'Enterprise Multi-Service Architecture',
      githubUrl: 'https://github.com/Harish-Raj-R',
      liveDemoType: 'CIVIC_DESK',
      featured: true
    },
    {
      id: 'ai-agri-app',
      title: 'AI-Driven Agriculture App: Multilingual Recommendation Engine',
      subtitle: 'Personalized Smart Farming & Crop Advisory System with IoT Telemetry',
      category: 'AI / IoT & Web',
      description: 'Engineered a multilingual smart farming application featuring an intelligent recommendation engine that analyzes real-time soil NPK, moisture, and microclimate telemetry to deliver personalized crop and fertilizer advisories. Secured 60,000 INR grant from Unnat Bharat Abhiyan.',
      bulletPoints: [
        'Secured 60k INR government funding from Unnat Bharat Abhiyan for impactful results in smart agricultural modernization.',
        'Built personalized ML recommendation algorithm matching soil parameters (N, P, K, pH, moisture, temp) to optimal crop yields.',
        'Led end-to-end UI/UX architecture and integrated hardware sensors with Arduino, Blynk IoT, and cloud telemetry.',
        'Crafted multilingual localized interface supporting regional languages for accessible farming assistance.'
      ],
      techStack: ['Angular', 'TypeScript', 'Arduino', 'AI/ML', 'Blynk IoT', 'Sensors (NPK/DHT)', 'Figma', 'Spring Boot REST'],
      badge: '60,000 INR Funded (Unnat Bharat Abhiyan)',
      fundingInfo: 'Govt Funded Project (Unnat Bharat Abhiyan)',
      githubUrl: 'https://github.com/Harish-Raj-R',
      liveDemoType: 'AGRI_APP',
      featured: true
    }
  ];

  private fallbackExperiences: Experience[] = [
    {
      role: 'Full Stack Java Developer Intern (Angular)',
      organization: 'Cognizant',
      location: 'Chennai, India',
      duration: 'April 2026 – August 2026',
      type: 'INTERNSHIP',
      tag: 'Industry Experience',
      bulletPoints: [
        'Building the Service Request Management and Notification modules end-to-end using Spring Boot, Spring Security, Spring Data JPA, and MySQL.',
        'Designed and exposed JWT-secured RESTful APIs routed through an API Gateway with Eureka Service Discovery for fault-tolerant microservice communication.',
        'Developed dynamic, accessible Angular Material UI screens consuming backend REST APIs and leveraging RxJS for reactive state and data streaming.',
        'Collaborated actively in an Agile/Scrum cross-functional team utilizing Git for version control, Postman for comprehensive API testing, and CI/CD pipelines.'
      ],
      technologies: ['Java', 'Spring Boot', 'Spring Security', 'Spring Data JPA', 'Angular', 'RxJS', 'Angular Material', 'JWT', 'MySQL', 'API Gateway', 'Eureka', 'Git', 'Postman', 'Agile']
    },
    {
      role: 'Community Lead & Technical Organizer',
      organization: 'Chennai Developers Guild / Tech Community',
      location: 'Chennai, India',
      duration: 'March 2024 – Present',
      type: 'LEADERSHIP',
      tag: 'Community Leadership',
      bulletPoints: [
        'Organized and directed 10+ high-impact hackathons, coding workshops, and developer technical sessions.',
        'Mentored emerging engineers in full-stack web development, microservice concepts, and software architecture.',
        'Scaled active developer community engagement across Chennai.'
      ],
      technologies: ['Community Leadership', 'Technical Mentorship', 'Hackathon Direction', 'Developer Ecosystems']
    },
    {
      role: 'Technical Coordinator',
      organization: 'Student Developer & Innovation Cell',
      location: 'Chennai, India',
      duration: 'August 2024 – 2026',
      type: 'LEADERSHIP',
      tag: 'Campus Leadership',
      bulletPoints: [
        'Conducted hands-on technical workshops on modern web architecture and Java backend systems.',
        'Facilitated collaborative hackathons and peer coding challenges.'
      ],
      technologies: ['Workshop Facilitation', 'Web Architecture', 'Java Systems', 'Technical Coordination']
    }
  ];

  private fallbackSkills: SkillCategory[] = [
    {
      category: 'Backend & Java Ecosystem',
      icon: 'server',
      description: 'Enterprise Java, Spring Boot microservices, security, and persistence',
      skills: [
        { name: 'Java', level: 95, tag: 'Core' },
        { name: 'Spring Boot', level: 92, tag: 'Core' },
        { name: 'Spring Security (JWT)', level: 88, tag: 'Core' },
        { name: 'Spring Data JPA / Hibernate', level: 90, tag: 'Core' },
        { name: 'Microservices Architecture', level: 88, tag: 'Core' },
        { name: 'Eureka Service Discovery', level: 85, tag: 'Proficient' },
        { name: 'API Gateway Routing', level: 86, tag: 'Proficient' },
        { name: 'RESTful API Design', level: 94, tag: 'Expert' }
      ]
    },
    {
      category: 'Frontend & Web Technologies',
      icon: 'layout',
      description: 'Modern Single Page Applications, reactive streams, and component design',
      skills: [
        { name: 'Angular (v17/18/19)', level: 92, tag: 'Core' },
        { name: 'TypeScript / JavaScript', level: 90, tag: 'Core' },
        { name: 'RxJS Observables & Reactive State', level: 88, tag: 'Core' },
        { name: 'Angular Material & CDK', level: 90, tag: 'Expert' },
        { name: 'Tailwind CSS / SCSS / Flexbox', level: 92, tag: 'Expert' },
        { name: 'HTML5 / Modern DOM APIs', level: 95, tag: 'Core' }
      ]
    },
    {
      category: 'Databases, Cloud & Dev Tools',
      icon: 'database',
      description: 'Relational databases, API testing, version control, and design systems',
      skills: [
        { name: 'MySQL / Relational Modeling', level: 88, tag: 'Core' },
        { name: 'SQL Query Optimization', level: 86, tag: 'Proficient' },
        { name: 'Git & GitHub Workflow', level: 92, tag: 'Expert' },
        { name: 'Postman / API Automation', level: 90, tag: 'Expert' },
        { name: 'VS Code / IntelliJ IDEA', level: 92, tag: 'Proficient' },
        { name: 'Figma UI/UX Prototyping', level: 85, tag: 'Proficient' }
      ]
    },
    {
      category: 'Hardware, VLSI & Embedded Systems',
      icon: 'cpu',
      description: 'VLSI architectures, digital system design, and IoT telemetry',
      skills: [
        { name: 'VLSI Design & Architecture', level: 90, tag: 'Core' },
        { name: 'System Verilog / Quartus / Xilinx', level: 85, tag: 'Proficient' },
        { name: 'Arduino / IoT Sensors (Blynk)', level: 84, tag: 'Proficient' },
        { name: 'MicroWind / PSpice / LTspice', level: 80, tag: 'Proficient' }
      ]
    }
  ];

  private fallbackAchievements: Achievement[] = [
    {
      title: "Unfold Hackathon '23",
      rank: '2nd Place Winner',
      event: 'Global Web3 & Systems Hackathon',
      year: '2023',
      prize: '$300 USD Cash Prize',
      description: 'Secured 2nd place among hundreds of participants, presenting high-performance decentralized and distributed architecture.',
      badgeColor: 'amber'
    },
    {
      title: 'Smart India Hackathon (SIH \'24)',
      rank: '6th Place (Internal Level)',
      event: 'Smart India Hackathon 2024',
      year: '2024',
      prize: 'National Stage Finalist Track',
      description: 'Ranked 6th in the competitive internal round of India\'s largest nationwide open innovation model.',
      badgeColor: 'emerald'
    },
    {
      title: 'SSN VIVID 8.0 National Project Expo',
      rank: '3rd Place',
      event: 'SSN College of Engineering',
      year: '2024',
      prize: 'Project Excellence Award',
      description: 'Awarded 3rd place in state-level project showcase for smart AI-driven agriculture recommendation system.',
      badgeColor: 'cyan'
    },
    {
      title: 'Kurukshetra \'24 (Anna University)',
      rank: '2nd Place',
      event: 'Kurukshetra International Techno-Management Fest',
      year: '2024',
      prize: 'Paper Presentation Laureate',
      description: 'Won 2nd place in Paper Presentation presenting research on AI algorithms and IoT sensor telemetry.',
      badgeColor: 'purple'
    },
    {
      title: 'Sri Venkateshwara College Paper Presentation',
      rank: '1st Place',
      event: 'National Technical Symposium',
      year: '2024',
      prize: '1st Prize Winner',
      description: 'Clinched 1st place for technical rigor and presentation clarity in smart embedded systems.',
      badgeColor: 'amber'
    },
    {
      title: 'RMKEC Idea Contest \'23',
      rank: '2nd Place',
      event: 'RMK Engineering College Innovation Cell',
      year: '2023',
      prize: 'Innovation Silver Award',
      description: 'Recognized for innovative municipal and smart city civic governance system.',
      badgeColor: 'emerald'
    },
    {
      title: 'Startup Cafe \'24',
      rank: 'Pre-Finalist',
      event: 'Entrepreneurship & Venture Summit',
      year: '2024',
      prize: 'Venture Pitch Recognition',
      description: 'Reached the Pre-Final stage demonstrating strong product-market fit, business acumen, and scalable architecture.',
      badgeColor: 'cyan'
    }
  ];

  private fallbackEducation: Education[] = [
    {
      institution: 'R.M.K Engineering College',
      degree: 'Bachelor of Engineering (B.E)',
      field: 'Electronics and Communication Engineering',
      duration: '2022 – 2026',
      score: 'CGPA: 8.47 / 10',
      location: 'Chennai, India',
      highlights: [
        'Distinction academic record (CGPA 8.47)',
        'Active leader in coding clubs and technical symposiums',
        'Honors in VLSI'
      ]
    },
    {
      institution: 'Sri Sankara Vidya Kendra Higher Secondary School',
      degree: 'Higher Secondary Certificate (12th & 10th Standard)',
      field: 'Computer Science & Mathematics Stream',
      duration: '2019 – 2022',
      score: '12th: 93.0% | 10th: 83.4%',
      location: 'Chennai, India',
      highlights: [
        'Top percentile score in 12th Board examinations (93%)',
        'Foundational training in computer programming and mathematics'
      ]
    }
  ];

  private fallbackCertifications: string[] = [
    'NPTEL: Introduction to IoT (Elite)',
    'NPTEL: Joy of Computing Using Python (Elite + Silver Medal)',
    'NPTEL: Python for Data Science (Elite)',
    'NPTEL: System Design Through Verilog',
    'TOEFL ITP Level 1: Score 553/677 (Speaking: 68 - C1 CEFR Level)'
  ];

  // API Methods
  getProfile(): Observable<Profile> {
    return this.http.get<Profile>(`${this.apiUrl}/portfolio/profile`).pipe(
      catchError(() => of(this.fallbackProfile))
    );
  }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${this.apiUrl}/portfolio/projects`).pipe(
      catchError(() => of(this.fallbackProjects))
    );
  }

  getExperience(): Observable<Experience[]> {
    return this.http.get<Experience[]>(`${this.apiUrl}/portfolio/experience`).pipe(
      catchError(() => of(this.fallbackExperiences))
    );
  }

  getSkills(): Observable<SkillCategory[]> {
    return this.http.get<SkillCategory[]>(`${this.apiUrl}/portfolio/skills`).pipe(
      catchError(() => of(this.fallbackSkills))
    );
  }

  getAchievements(): Observable<Achievement[]> {
    return this.http.get<Achievement[]>(`${this.apiUrl}/portfolio/achievements`).pipe(
      catchError(() => of(this.fallbackAchievements))
    );
  }

  getEducation(): Observable<Education[]> {
    return this.http.get<Education[]>(`${this.apiUrl}/portfolio/education`).pipe(
      catchError(() => of(this.fallbackEducation))
    );
  }

  getCertifications(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/portfolio/certifications`).pipe(
      catchError(() => of(this.fallbackCertifications))
    );
  }

  // CivicDesk Microservices Simulation
  getCivicRegistry(): Observable<Record<string, unknown>> {
    return this.http.get<Record<string, unknown>>(`${this.apiUrl}/civicdesk/eureka/registry`).pipe(
      catchError(() => of({
        'CIVIC-API-GATEWAY': { port: 8080, status: 'UP', instances: 2, routePrefix: '/api/v1/*' },
        'SERVICE-REQUEST-MGMT': { port: 8081, status: 'UP', instances: 3, db: 'MySQL-Cluster' },
        'NOTIFICATION-SERVICE': { port: 8082, status: 'UP', instances: 2, async: 'RxJS/SSE' },
        'AUTH-JWT-SECURITY': { port: 8083, status: 'UP', instances: 2, algo: 'HMAC-SHA256' },
        'CITIZEN-IDENTITY-SVC': { port: 8084, status: 'UP', instances: 1 },
        'OFFICER-DISPATCH-SVC': { port: 8085, status: 'UP', instances: 2 },
        'EUREKA-SERVER-CORE': { port: 8761, status: 'UP', mode: 'STANDALONE' }
      }))
    );
  }

  getCivicRequests(): Observable<CivicServiceRequest[]> {
    return this.http.get<CivicServiceRequest[]>(`${this.apiUrl}/civicdesk/requests`).pipe(
      catchError(() => of([
        {
          requestId: 'CR-2026-8941',
          citizenName: 'Arun Kumar',
          department: 'WATER_SUPPLY',
          title: 'Low water pressure in Ward 14 pipeline',
          description: 'Water pressure dropped significantly since Monday morning.',
          priority: 'HIGH',
          status: 'IN_PROGRESS',
          assignedOfficer: 'Officer Rajesh V (Zone 3)',
          gatewayTraceId: 'gw-trace-8f92a10c',
          microserviceNode: 'SRV-REQ-NODE-02',
          timestamp: new Date().toISOString()
        },
        {
          requestId: 'CR-2026-8942',
          citizenName: 'Meenakshi S',
          department: 'STREET_LIGHTS',
          title: 'LED Streetlight flickering at Main Junction',
          description: 'Light pole #42 on Anna Salai 4th Cross is malfunctioning.',
          priority: 'MEDIUM',
          status: 'RESOLVED',
          assignedOfficer: 'Officer Kavitha M (Electrical Div)',
          gatewayTraceId: 'gw-trace-3a71bc9d',
          microserviceNode: 'SRV-REQ-NODE-01',
          timestamp: new Date().toISOString()
        }
      ]))
    );
  }

  createCivicRequest(request: CivicServiceRequest): Observable<CivicServiceRequest> {
    return this.http.post<CivicServiceRequest>(`${this.apiUrl}/civicdesk/requests`, request).pipe(
      catchError(() => of({
        ...request,
        requestId: 'CR-2026-' + Math.floor(1000 + Math.random() * 9000),
        status: 'SUBMITTED',
        gatewayTraceId: 'gw-trace-' + Math.random().toString(36).substring(2, 10),
        microserviceNode: 'SRV-REQ-NODE-0' + Math.floor(1 + Math.random() * 3),
        timestamp: new Date().toISOString()
      }))
    );
  }

  updateCivicStatus(id: string, status: string, officer: string): Observable<CivicServiceRequest> {
    return this.http.put<CivicServiceRequest>(`${this.apiUrl}/civicdesk/requests/${id}/status`, { status, officer }).pipe(
      catchError(() => of({
        requestId: id,
        citizenName: 'Citizen',
        department: 'GENERAL',
        title: 'Updated Request',
        description: 'Status updated to ' + status,
        priority: 'MEDIUM',
        status: status,
        assignedOfficer: officer,
        gatewayTraceId: 'gw-trace-local-sync',
        microserviceNode: 'SRV-REQ-NODE-01',
        timestamp: new Date().toISOString()
      }))
    );
  }

  getCivicNotifications(): Observable<CivicNotification[]> {
    return this.http.get<CivicNotification[]>(`${this.apiUrl}/civicdesk/notifications`).pipe(
      catchError(() => of([
        {
          id: 'notif-1',
          recipientRole: 'CITIZEN',
          message: 'Your service request CR-2026-8942 has been marked as RESOLVED by Officer Kavitha M.',
          type: 'STATUS_UPDATE',
          requestId: 'CR-2026-8942',
          timestamp: new Date().toISOString()
        }
      ]))
    );
  }

  simulateJwtAuth(username: string): Observable<Record<string, unknown>> {
    return this.http.post<Record<string, unknown>>(`${this.apiUrl}/civicdesk/auth/simulate-jwt`, { username }).pipe(
      catchError(() => of({
        token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI' + btoa(username) + 'IiwiZXhwIjoxNzYwMDAwMDAwfQ.simulated_jwt_signature',
        tokenType: 'Bearer',
        expiresInSeconds: 3600,
        username,
        authenticatedVia: 'Spring Security 6 + Eureka API Gateway'
      }))
    );
  }

  // AI Agriculture Recommendation
  getAgriRecommendation(telemetry: AgriTelemetry): Observable<AgriRecommendation> {
    return this.http.post<AgriRecommendation>(`${this.apiUrl}/agri/recommend`, telemetry).pipe(
      catchError(() => {
        let crop = 'Paddy / Rice (Kharif/Rabi)';
        if (telemetry.temperature > 28 && telemetry.soilMoisture < 45) {
          crop = 'Groundnut / Peanut (Arachis hypogaea)';
        } else if (telemetry.nitrogen >= 60 && telemetry.phosphorus >= 40) {
          crop = 'Maize / Corn (Zea mays)';
        } else if (telemetry.soilMoisture < 35) {
          crop = 'Pearl Millet / Bajra';
        }
        return of({
          recommendedCrop: crop,
          confidenceScore: 0.95,
          rationale: `Optimal NPK (${telemetry.nitrogen}-${telemetry.phosphorus}-${telemetry.potassium}) and ${telemetry.soilMoisture}% moisture support high yield.`,
          fertilizerAdvice: 'Apply balanced NPK fertilizer with bio-organic compost.',
          irrigationSchedule: 'Irrigate every 3-4 days during vegetative stage.',
          climateSuitability: `Temperature of ${telemetry.temperature}°C is ideal for maximum photosynthetic rate.`,
          localizedTips: [
            'Backed by 60,000 INR Unnat Bharat Abhiyan Research Grant',
            'Integrates with real-time Arduino NPK & DHT22 soil sensors'
          ],
          predictedYield: '4.5 - 5.2 Metric Tonnes / Hectare'
        });
      })
    );
  }

  // Contact
  sendContactMessage(msg: ContactMessage): Observable<{ status: string; message: string; messageId?: string }> {
    return this.http.post<{ status: string; message: string; messageId?: string }>(`${this.apiUrl}/contact/send`, msg).pipe(
      catchError(() => of({
        status: 'SUCCESS',
        message: `Thank you, ${msg.name}! Your message has been simulated successfully.`
      }))
    );
  }
}
