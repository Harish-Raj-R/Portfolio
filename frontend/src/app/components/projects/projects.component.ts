import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { Project } from '../../models/portfolio.model';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.scss']
})
export class ProjectsComponent implements OnInit {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  projects = signal<Project[]>([]);

  ngOnInit() {
    this.portfolioService.getProjects().subscribe(data => this.projects.set(data));
  }

  onHover() {
    this.soundService.playHover();
  }

  onClick() {
    this.soundService.playClick();
  }
}
