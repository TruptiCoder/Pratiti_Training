import { Component, OnDestroy, OnInit } from '@angular/core';
import { Counter } from '../counter';

@Component({
  selector: 'app-comp2',
  imports: [],
  templateUrl: './comp2.html',
  styleUrl: './comp2.css',
})
export class Comp2 implements OnDestroy {
  constructor(private counter: Counter) {
    console.log('comp2 constructor');
    queueMicrotask(() => {
      this.counter.increment();
    });
  }

  ngOnDestroy() {
    console.log('comp2 destroy');
    queueMicrotask(() => {
      this.counter.decrement();
    });
  }
}
