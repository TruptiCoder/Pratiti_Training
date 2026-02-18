import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-tp',
  imports: [],
  templateUrl: './tp.html',
  styleUrl: './tp.css',
})
export class Tp {
  @Input()
  uname:string = "";

  @Input()
  count:number = 0;
}
