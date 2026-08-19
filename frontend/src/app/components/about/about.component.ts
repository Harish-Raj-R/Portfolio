import { Component, inject, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { Education, Profile } from '../../models/portfolio.model';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  profile = signal<Profile | null>(null);
  educationList = signal<Education[]>([]);
  activeTab = signal<'education' | 'bio' | 'certifications'>('education');

  ngOnInit() {
    this.portfolioService.getProfile().subscribe(data => this.profile.set(data));
    this.portfolioService.getEducation().subscribe(data => this.educationList.set(data));
  }

  setTab(tab: 'education' | 'bio' | 'certifications') {
    this.soundService.playClick();
    this.activeTab.set(tab);
  }

  onHover() {
    this.soundService.playHover();
  }
}
