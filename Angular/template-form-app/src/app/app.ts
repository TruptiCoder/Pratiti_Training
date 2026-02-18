import { CommonModule } from '@angular/common';
import { Component, OnInit, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
   selector: 'app-root',
   imports: [RouterOutlet,ReactiveFormsModule, CommonModule],
   templateUrl: './app.html',
   styleUrl: './app.css'
})
export class App implements OnInit {
   protected readonly title = signal('reactive-form-app');
   userName: string = ""; 
   formdata: FormGroup = new FormGroup({});
   ngOnInit() { 
      this.formdata = new FormGroup({ 
      userName: new FormControl("") 
      }); 
   } 
   onClickSubmit(data: { userName: string }) { 
      this.userName = data.userName; 
   }
}