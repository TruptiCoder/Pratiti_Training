import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Tp } from './tp';

describe('Tp', () => {
  let component: Tp;
  let fixture: ComponentFixture<Tp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Tp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Tp);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
