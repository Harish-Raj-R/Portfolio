import { Component, ElementRef, ViewChild, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SoundService } from '../../services/sound.service';
import confetti from 'canvas-confetti';

interface TerminalLine {
  text: string;
  type: 'input' | 'output' | 'error' | 'success' | 'info';
}

@Component({
  selector: 'app-terminal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './terminal.component.html',
  styleUrls: ['./terminal.component.scss']
})
export class TerminalComponent {
  @ViewChild('termScroll') termScrollRef!: ElementRef<HTMLDivElement>;
  soundService = inject(SoundService);

  inputCommand = '';
  history: TerminalLine[] = [
    { text: 'HarishRajOS v2.4.0 (x86_64-pc-linux-gnu)', type: 'info' },
    { text: 'Type "help" to see available terminal commands.', type: 'output' }
  ];

  commandList = [
    'help', 'resume', 'about', 'skills', 'projects', 'cognizant', 
    'trophies', 'contact', 'clear', 'sudo hire', 'matrix'
  ];

  executeCommand() {
    const cmd = this.inputCommand.trim().toLowerCase();
    if (!cmd) return;

    this.soundService.playClick();
    this.history.push({ text: `harish@dev:~$ ${this.inputCommand}`, type: 'input' });

    switch (cmd) {
      case 'help':
        this.history.push({
          text: `Available Commands:
  • resume      - View and download Harish's Curriculum Vitae (PDF)
  • about       - Overview & academic distinctions (RMKEC Honors in VLSI)
  • cognizant   - Cognizant Full-Stack Java/Angular internship details
  • skills      - Core tech stack (Spring Boot, Angular, RxJS, Microservices)
  • projects    - CivicDesk & AI Agriculture apps
  • trophies    - Hackathon victories (Unfold $300, SIH '24, SSN VIVID)
  • contact     - Direct phone, email, and social coordinates
  • sudo hire   - Dispatch high-priority recruitment pipeline
  • matrix      - Cyber animation stream
  • clear       - Clean terminal screen`,
          type: 'output'
        });
        break;

      case 'resume':
        window.open('assets/resume.pdf', '_blank');
        this.history.push({
          text: `[RESUME OPENED] Opening resume.pdf in a new tab...
Direct Link: assets/resume.pdf`,
          type: 'success'
        });
        break;

      case 'about':
        this.history.push({
          text: `Harish Raj R - Full Stack Java & Angular Engineer
Degree: B.E in Electronics & Communication Engineering (R.M.K. Engineering College)
Honors: Honors in VLSI | CGPA: 8.47 / 10
TOEFL ITP: 553/677 [Speaking: 68 - C1 Level]
Cognizant Full Stack Intern & Unnat Bharat Abhiyan Grantee.`,
          type: 'output'
        });
        break;

      case 'cognizant':
        this.history.push({
          text: `Cognizant (April 2026 – August 2026) - Full Stack Java Developer Intern
• Built Service Request Management & Notification modules end-to-end.
• Spring Boot, Spring Security (JWT), Eureka Service Discovery, API Gateway.
• Reactive Angular Material UI screens with RxJS observables.`,
          type: 'success'
        });
        break;

      case 'skills':
        this.history.push({
          text: `Backend:  Java 21, Spring Boot 3, Spring Security, Spring Data JPA, Microservices, Eureka, REST
Frontend: Angular 19, TypeScript, RxJS, Angular Material, Tailwind CSS, SCSS
Data/Tools: MySQL, Git, Postman, VS Code, Figma
Hardware: VLSI Architecture, Arduino, Blynk IoT, Sensors, System Verilog`,
          type: 'output'
        });
        break;

      case 'projects':
        this.history.push({
          text: `1. CivicDesk – Municipal Engagement & Operations Portal (Cognizant Project)
   Spring Boot microservices, JWT, Eureka, Angular Material, RxJS.
2. AI-Driven Agriculture App (60,000 INR Funded by Unnat Bharat Abhiyan)
   Multilingual recommendation engine, Arduino IoT, ML crop advisory.`,
          type: 'output'
        });
        break;

      case 'trophies':
        this.history.push({
          text: `🏆 Unfold Hackathon '23: 2nd Place ($300 USD)
🥇 Smart India Hackathon '24: 6th Place Internal
🌟 SSN VIVID 8.0: 3rd Place Expo
📜 Kurukshetra '24 (Anna University): 2nd Place Paper Presentation
🥇 Sri Venkateshwara College: 1st Place
🥈 RMKEC Idea Contest '23: 2nd Place`,
          type: 'success'
        });
        break;

      case 'contact':
        this.history.push({
          text: `Email:    itsharishrajr@gmail.com
Phone:    +91 8778726685
LinkedIn: https://linkedin.com/in/harish-raj-r-
GitHub:   https://github.com/Harish-Raj-R`,
          type: 'info'
        });
        break;

      case 'sudo hire':
        this.soundService.playSuccess();
        confetti({
          particleCount: 100,
          spread: 80,
          origin: { y: 0.6 }
        });
        this.history.push({
          text: `[SUCCESS] High priority candidate unlocked! Scroll down to #contact or email itsharishrajr@gmail.com! 🚀`,
          type: 'success'
        });
        break;

      case 'matrix':
        this.history.push({
          text: `01001000 01100001 01110010 01101001 01110011 01101000 00100000 01010010 01100001 01101010
Wake up, Neo... The Matrix has you. Follow the white rabbit. 🐇`,
          type: 'info'
        });
        break;

      case 'clear':
        this.history = [];
        break;

      default:
        this.history.push({
          text: `Command not found: "${this.inputCommand}". Type "help" for a list of commands.`,
          type: 'error'
        });
        break;
    }

    this.inputCommand = '';
    setTimeout(() => {
      if (this.termScrollRef) {
        this.termScrollRef.nativeElement.scrollTop = this.termScrollRef.nativeElement.scrollHeight;
      }
    }, 50);
  }

  runQuickCmd(cmd: string) {
    this.inputCommand = cmd;
    this.executeCommand();
  }
}
