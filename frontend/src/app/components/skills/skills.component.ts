import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { SkillCategory } from '../../models/portfolio.model';

@Component({
  selector: 'app-skills',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.scss']
})
export class SkillsComponent implements OnInit {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  categories = signal<SkillCategory[]>([]);
  activeCategoryIndex = signal(0);

  ngOnInit() {
    this.portfolioService.getSkills().subscribe(data => this.categories.set(data));
  }

  selectCategory(index: number) {
    this.soundService.playClick();
    this.activeCategoryIndex.set(index);
  }

  onHover() {
    this.soundService.playHover();
  }
}
