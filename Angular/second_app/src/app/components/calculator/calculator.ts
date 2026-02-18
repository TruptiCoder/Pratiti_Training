import { Component } from '@angular/core';
import { NormalCalc } from './normal-calc/normal-calc';
import { SciCalc } from './sci-calc/sci-calc';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-calculator',
  imports: [NormalCalc, SciCalc, RouterLink, RouterOutlet],
  templateUrl: './calculator.html',
  styleUrl: './calculator.css',
})
export class Calculator {

}
