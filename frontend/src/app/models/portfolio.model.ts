export interface Profile {
  name: string;
  title: string;
  tagLine: string;
  email: string;
  phone: string;
  linkedIn: string;
  github: string;
  location: string;
  summary: string;
  highlights: string[];
  toeflScore: string;
}

export interface Project {
  id: string;
  title: string;
  subtitle: string;
  category: string;
  description: string;
  bulletPoints: string[];
  techStack: string[];
  badge: string;
  fundingInfo?: string;
  githubUrl: string;
  liveDemoType: 'CIVIC_DESK' | 'AGRI_APP' | 'EXTERNAL';
  featured: boolean;
}

export interface Experience {
  role: string;
  organization: string;
  location: string;
  duration: string;
  type: 'INTERNSHIP' | 'LEADERSHIP';
  tag: string;
  bulletPoints: string[];
  technologies: string[];
}

export interface SkillItem {
  name: string;
  level: number;
  tag: string;
}

export interface SkillCategory {
  category: string;
  icon: string;
  description: string;
  skills: SkillItem[];
}

export interface Achievement {
  title: string;
  rank: string;
  event: string;
  year: string;
  prize: string;
  description: string;
  badgeColor: 'amber' | 'emerald' | 'cyan' | 'purple';
}

export interface Education {
  institution: string;
  degree: string;
  field: string;
  duration: string;
  score: string;
  location: string;
  highlights: string[];
}

export interface CivicServiceRequest {
  requestId?: string;
  citizenName: string;
  department: string;
  title: string;
  description: string;
  priority: string;
  status?: string;
  assignedOfficer?: string;
  gatewayTraceId?: string;
  microserviceNode?: string;
  timestamp?: string;
}

export interface CivicNotification {
  id: string;
  recipientRole: string;
  message: string;
  type: string;
  requestId: string;
  timestamp: string;
}

export interface AgriTelemetry {
  nitrogen: number;
  phosphorus: number;
  potassium: number;
  soilMoisture: number;
  ph: number;
  temperature: number;
  humidity: number;
  soilType: string;
  language: string;
}

export interface AgriRecommendation {
  recommendedCrop: string;
  confidenceScore: number;
  rationale: string;
  fertilizerAdvice: string;
  irrigationSchedule: string;
  climateSuitability: string;
  localizedTips: string[];
  predictedYield: string;
}

export interface ContactMessage {
  name: string;
  email: string;
  organization?: string;
  subject?: string;
  message: string;
}
