import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Counter {
  private countSubject = new BehaviorSubject<number>(0);
  count$ = this.countSubject.asObservable();

  increment() {
    const current = this.countSubject.getValue();
    this.countSubject.next(current + 1);
  }

  decrement() {
    const current = this.countSubject.getValue();
    this.countSubject.next(current - 1);
  }
}
