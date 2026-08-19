import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { Achievement } from '../../models/portfolio.model';
import confetti from 'canvas-confetti';

@Component({
  selector: 'app-achievements',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './achievements.component.html',
  styleUrls: ['./achievements.component.scss']
})
export class AchievementsComponent implements OnInit {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  achievements = signal<Achievement[]>([]);

  ngOnInit() {
    this.portfolioService.getAchievements().subscribe(data => this.achievements.set(data));
  }

  celebrate(ach: Achievement) {
    this.soundService.playSuccess();
    const colors = ach.badgeColor === 'amber' ? ['#fbbf24', '#f59e0b', '#ffffff'] :
                   ach.badgeColor === 'emerald' ? ['#34d399', '#10b981', '#ffffff'] :
                   ach.badgeColor === 'cyan' ? ['#38bdf8', '#06b6d4', '#ffffff'] : ['#c084fc', '#8b5cf6', '#ffffff'];
    confetti({
      particleCount: 60,
      spread: 70,
      origin: { y: 0.6 },
      colors
    });
  }

  onHover() {
    this.soundService.playHover();
  }
}
