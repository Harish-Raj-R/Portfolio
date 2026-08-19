import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PortfolioService } from '../../services/portfolio.service';
import { SoundService } from '../../services/sound.service';
import { ContactMessage } from '../../models/portfolio.model';
import confetti from 'canvas-confetti';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent {
  portfolioService = inject(PortfolioService);
  soundService = inject(SoundService);

  formModel: ContactMessage = {
    name: '',
    email: '',
    organization: '',
    subject: '',
    message: ''
  };

  isSubmitting = signal(false);
  submitSuccess = signal(false);
  copyToast = signal<string | null>(null);

  contactDetails = {
    email: 'itsharishrajr@gmail.com',
    phone: '+91 8778726685',
    linkedIn: 'https://linkedin.com/in/harish-raj-r-',
    github: 'https://github.com/Harish-Raj-R',
    location: 'Chennai, Tamil Nadu, India'
  };

  onSubmit() {
    if (!this.formModel.name || !this.formModel.email || !this.formModel.message) return;

    this.isSubmitting.set(true);
    this.soundService.playClick();

    this.portfolioService.sendContactMessage(this.formModel).subscribe(res => {
      this.isSubmitting.set(false);
      this.submitSuccess.set(true);
      this.soundService.playSuccess();
      confetti({
        particleCount: 80,
        spread: 80,
        origin: { y: 0.6 }
      });

      this.formModel = {
        name: '',
        email: '',
        organization: '',
        subject: '',
        message: ''
      };

      setTimeout(() => this.submitSuccess.set(false), 8000);
    });
  }

  copyToClipboard(text: string, label: string) {
    this.soundService.playClick();
    navigator.clipboard.writeText(text);
    this.copyToast.set(`Copied ${label} to clipboard!`);
    setTimeout(() => this.copyToast.set(null), 3000);
  }

  onHover() {
    this.soundService.playHover();
  }
}
