import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Trupti } from './components/trupti';
import { UpperCasePipe } from '@angular/common';
import { Employee } from './components/employee/employee';
import { Calculator } from './components/calculator/calculator';

@Component({
  selector: 'app-root',
  imports: [Trupti, UpperCasePipe, Employee, Calculator],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = 'hello-app';
}


// To generate component automatically
// ng generate  component comp_name