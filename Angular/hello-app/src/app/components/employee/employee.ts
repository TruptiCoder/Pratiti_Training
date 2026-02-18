import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Calculator } from '../../../calculator';

@Component({
  selector: 'app-employee',
  imports: [FormsModule],
  templateUrl: './employee.html',
  styleUrl: './employee.css',
})
export class Employee {
  counter = 0;
  uname = "Trupti";
  total = 1;

  constructor(private calculator: Calculator) {

  }

  abc() {
    this.total = this.calculator.addNubmers( 7, this.total);
    // console.log("ABC called")
    ++this.counter;
    // console.log(this.uname, this.counter);
  }
}
