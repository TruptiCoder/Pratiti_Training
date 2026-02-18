import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Navbar } from './components/navbar/navbar';
import { Home } from './components/home/home';
import { Calculator } from './components/calculator/calculator';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Home, Calculator],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('second_app');
}
