import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee',
  imports: [FormsModule],
  templateUrl: './employee.html',
  styleUrl: './employee.css',
})
export class Employee {
  counter = 0;
  uname = "Trupti";
  abc() {
    console.log("ABC called")
    ++this.counter;
    console.log(this.uname, this.counter);
  }
}
