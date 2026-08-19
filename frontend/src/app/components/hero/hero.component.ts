import { Component, ElementRef, ViewChild, AfterViewInit, OnDestroy, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SoundService } from '../../services/sound.service';
import confetti from 'canvas-confetti';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.scss']
})
export class HeroComponent implements AfterViewInit, OnDestroy {
  @ViewChild('particleCanvas') canvasRef!: ElementRef<HTMLCanvasElement>;
  
  soundService = inject(SoundService);

  roles = [
    'Full Stack Java Developer',
    'Angular & RxJS Specialist',
    'Spring Boot Microservices Architect',
    'Unfold Hackathon Winner ($300 USD)',
    '60k INR Funded Agri-Tech Innovator'
  ];
  
  currentRoleIndex = 0;
  displayedRole = signal(this.roles[0]);
  private typingTimer: ReturnType<typeof setTimeout> | null = null;
  private animFrameId: number | null = null;

  techPills = [
    { name: 'Java 21 / Spring Boot 3', icon: '⚡' },
    { name: 'Angular 19 / RxJS', icon: '🅰️' },
    { name: 'Microservices & Eureka', icon: '🌐' },
    { name: 'Spring Security (JWT)', icon: '🔒' },
    { name: 'MySQL / JPA', icon: '💾' },
    { name: 'VLSI & IoT Telemetry', icon: '📐' },
  ];

  stats = [
    { label: 'Cognizant Internship', value: 'Full Stack', sub: 'Spring Boot & Angular' },
    { label: 'Project Grant', value: '60,000 INR', sub: 'Unnat Bharat Abhiyan' },
    { label: 'Laurels & Hackathons', value: '6+ Awards', sub: 'National & Global' },
    { label: 'Academic Standing', value: '8.47 CGPA', sub: 'B.E ECE (Honors in VLSI)' },
  ];

  ngAfterViewInit() {
    this.initTypewriter();
    this.initParticles();
  }

  ngOnDestroy() {
    if (this.typingTimer) clearTimeout(this.typingTimer);
    if (this.animFrameId) cancelAnimationFrame(this.animFrameId);
  }

  private initTypewriter() {
    let charIdx = 0;
    let isDeleting = false;

    const tick = () => {
      const currentRole = this.roles[this.currentRoleIndex];

      if (isDeleting) {
        this.displayedRole.set(currentRole.substring(0, charIdx - 1));
        charIdx--;
      } else {
        this.displayedRole.set(currentRole.substring(0, charIdx + 1));
        charIdx++;
      }

      let delta = isDeleting ? 40 : 80;

      if (!isDeleting && charIdx === currentRole.length) {
        delta = 2200; // Hold full text
        isDeleting = true;
      } else if (isDeleting && charIdx === 0) {
        isDeleting = false;
        this.currentRoleIndex = (this.currentRoleIndex + 1) % this.roles.length;
        delta = 400;
      }

      this.typingTimer = setTimeout(tick, delta);
    };

    tick();
  }

  private initParticles() {
    const canvas = this.canvasRef.nativeElement;
    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    let width = (canvas.width = canvas.parentElement?.clientWidth || window.innerWidth);
    let height = (canvas.height = canvas.parentElement?.clientHeight || 650);

    const handleResize = () => {
      width = canvas.width = canvas.parentElement?.clientWidth || window.innerWidth;
      height = canvas.height = canvas.parentElement?.clientHeight || 650;
    };
    window.addEventListener('resize', handleResize);

    const particleCount = Math.min(Math.floor(width / 18), 70);
    const particles: Array<{
      x: number;
      y: number;
      vx: number;
      vy: number;
      size: number;
      color: string;
    }> = [];

    const colors = ['rgba(56, 189, 248, 0.6)', 'rgba(129, 140, 248, 0.6)', 'rgba(52, 211, 153, 0.5)', 'rgba(251, 191, 36, 0.5)'];

    for (let i = 0; i < particleCount; i++) {
      particles.push({
        x: Math.random() * width,
        y: Math.random() * height,
        vx: (Math.random() - 0.5) * 0.8,
        vy: (Math.random() - 0.5) * 0.8,
        size: Math.random() * 2.5 + 1,
        color: colors[Math.floor(Math.random() * colors.length)]
      });
    }

    let mouseX = -1000;
    let mouseY = -1000;

    canvas.addEventListener('mousemove', (e) => {
      const rect = canvas.getBoundingClientRect();
      mouseX = e.clientX - rect.left;
      mouseY = e.clientY - rect.top;
    });

    canvas.addEventListener('mouseleave', () => {
      mouseX = -1000;
      mouseY = -1000;
    });

    const draw = () => {
      ctx.clearRect(0, 0, width, height);

      // Connect particles
      for (let i = 0; i < particles.length; i++) {
        for (let j = i + 1; j < particles.length; j++) {
          const dx = particles[i].x - particles[j].x;
          const dy = particles[i].y - particles[j].y;
          const dist = Math.sqrt(dx * dx + dy * dy);

          if (dist < 110) {
            ctx.beginPath();
            ctx.strokeStyle = `rgba(56, 189, 248, ${0.15 * (1 - dist / 110)})`;
            ctx.lineWidth = 0.8;
            ctx.moveTo(particles[i].x, particles[i].y);
            ctx.lineTo(particles[j].x, particles[j].y);
            ctx.stroke();
          }
        }
      }

      // Draw & update particles
      particles.forEach(p => {
        // Mouse repulsion
        const dx = p.x - mouseX;
        const dy = p.y - mouseY;
        const dist = Math.sqrt(dx * dx + dy * dy);
        if (dist < 80) {
          const force = (80 - dist) / 80;
          p.x += (dx / dist) * force * 3;
          p.y += (dy / dist) * force * 3;
        }

        p.x += p.vx;
        p.y += p.vy;

        if (p.x < 0) p.x = width;
        if (p.x > width) p.x = 0;
        if (p.y < 0) p.y = height;
        if (p.y > height) p.y = 0;

        ctx.beginPath();
        ctx.arc(p.x, p.y, p.size, 0, Math.PI * 2);
        ctx.fillStyle = p.color;
        ctx.fill();
      });

      this.animFrameId = requestAnimationFrame(draw);
    };

    draw();
  }

  triggerCelebration() {
    this.soundService.playSuccess();
    confetti({
      particleCount: 80,
      spread: 70,
      origin: { y: 0.6 },
      colors: ['#38bdf8', '#818cf8', '#34d399', '#fbbf24']
    });
  }

  onHover() {
    this.soundService.playHover();
  }

  onClick() {
    this.soundService.playClick();
  }
}
