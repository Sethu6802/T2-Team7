import { Component } from '@angular/core';
import { SosService } from '../sos.service';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrl: './sos.component.css'
})
export class SosComponent {

  constructor(private sosService: SosService) {}

  sendMsg() {
    console.log("I'm a Victim");
  
    this.sosService.sendMessage().subscribe({
      next: (data: any) => {
        for (const key in data) {
          if (data.hasOwnProperty(key)) {
            console.log(`${key.charAt(0).toUpperCase() + key.slice(1)}: ${data[key]}`);
          }
        }
      },
      error: (error) => {
        console.error('Error occurred:', error);
      }
    });
  }
}
