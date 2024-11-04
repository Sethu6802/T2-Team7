import { Component } from '@angular/core';
import { SosServiceService } from '../sos-service.service';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.css']
})

export class SosComponent {

  constructor(private sosService: SosServiceService) {}

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