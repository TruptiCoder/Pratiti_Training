import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NormalCalc } from './normal-calc';

describe('NormalCalc', () => {
  let component: NormalCalc;
  let fixture: ComponentFixture<NormalCalc>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NormalCalc]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NormalCalc);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
