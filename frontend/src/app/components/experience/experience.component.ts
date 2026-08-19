import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { Experience } from '../../models/portfolio.model';

@Component({
  selector: 'app-experience',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.scss']
})
export class ExperienceComponent implements OnInit {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  experiences = signal<Experience[]>([]);
  activeFilter = signal<'ALL' | 'INTERNSHIP' | 'LEADERSHIP'>('ALL');

  ngOnInit() {
    this.portfolioService.getExperience().subscribe(data => this.experiences.set(data));
  }

  setFilter(filter: 'ALL' | 'INTERNSHIP' | 'LEADERSHIP') {
    this.soundService.playClick();
    this.activeFilter.set(filter);
  }

  get filteredExperiences() {
    if (this.activeFilter() === 'ALL') {
      return this.experiences();
    }
    return this.experiences().filter(e => e.type === this.activeFilter());
  }

  onHover() {
    this.soundService.playHover();
  }
}
