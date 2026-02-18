import { Component, OnDestroy, OnInit } from '@angular/core';
import { Counter } from '../counter';

@Component({
  selector: 'app-comp1',
  imports: [],
  templateUrl: './comp1.html',
  styleUrl: './comp1.css',
})
export class Comp1 implements OnDestroy {
  constructor(private counter: Counter) {
    console.log('comp1 constructor');
    queueMicrotask(() => {
      this.counter.increment();
    });
  }

  ngOnDestroy() {
    console.log('comp1 destroy');
    queueMicrotask(() => {
      this.counter.decrement();
    });
  }
}
