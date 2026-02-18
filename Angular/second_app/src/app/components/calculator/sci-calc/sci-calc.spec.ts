import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SciCalc } from './sci-calc';

describe('SciCalc', () => {
  let component: SciCalc;
  let fixture: ComponentFixture<SciCalc>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SciCalc]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SciCalc);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
