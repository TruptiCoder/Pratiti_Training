import { Component, signal } from '@angular/core';
import { Tp } from '../tp/tp';

@Component({
  selector: 'app-home',
  imports: [Tp],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  count = 0;
  value = '';
  lastKey = '';
  show = signal(true);

  increment() { this.count++; }
  onInput(e: Event) { this.value = (e.target as HTMLInputElement).value; }
}
