import { Component } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrl: './error.component.css'
})
export class ErrorComponent {
  message: string = 'Something went wrong. Please Try Again.'
  code:  string = '500'
}
