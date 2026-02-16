import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  imports: [FormsModule],
  templateUrl: './calculator.html',
  styleUrl: './calculator.css',
})
export class Calculator {
  num1 = 0;
  num2 = 0;
  result = 0;

  add() {
    this.result = this.num1 + this.num2;
    console.log(this.result)
  }
  subtract() {
    this.result = this.num1 - this.num2;
    console.log(this.result)
  }
  multiply() {
    this.result = this.num1 * this.num2;
    console.log(this.result)
  }
  divide() {
    this.result = this.num1 / this.num2;
    console.log(this.result)
  }
}
