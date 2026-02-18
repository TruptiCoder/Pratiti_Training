import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Counter } from '../counter';
import { Comp1 } from '../comp1/comp1';
import { Comp2 } from '../comp2/comp2';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Comp1, Comp2, AsyncPipe],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('test-app');

  comp1 = false;
  comp2 = false;

  constructor(public counter: Counter) {}

  ngOnInit() {
    queueMicrotask(() => {
      this.counter.increment();
    });
  }

  ngOnDestroy() {
    queueMicrotask(() => {
      this.counter.decrement();
    });
  }

  showcomp1() {
    this.comp1 = !this.comp1;
  }

  showcomp2() {
    this.comp2 = !this.comp2;
  }
}
