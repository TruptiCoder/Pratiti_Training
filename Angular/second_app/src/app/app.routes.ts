import { Routes } from '@angular/router';
import { Home } from './components/home/home';
import { NormalCalc } from './components/calculator/normal-calc/normal-calc';
import { SciCalc } from './components/calculator/sci-calc/sci-calc';
import { Calculator } from './components/calculator/calculator';

export const routes: Routes = [
  {
    path: 'cal',
    component: Calculator,
    children: [
      { path: 'ncal', component: NormalCalc },
      { path: 'scal', component: SciCalc },
    ],
  },
  {path: "", component: Home}
];
