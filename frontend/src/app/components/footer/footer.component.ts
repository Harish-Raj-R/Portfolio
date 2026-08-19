import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SoundService } from '../../services/sound.service';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent {
  soundService = inject(SoundService);
  currentYear = new Date().getFullYear();

  scrollToTop() {
    this.soundService.playClick();
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  onHover() {
    this.soundService.playHover();
  }
}
