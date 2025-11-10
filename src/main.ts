import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app'; // <-- Mude 'App' para 'AppComponent' e o caminho

bootstrapApplication(AppComponent, appConfig) // <-- Mude 'App' para 'AppComponent'
  .catch((err) => console.error(err));
