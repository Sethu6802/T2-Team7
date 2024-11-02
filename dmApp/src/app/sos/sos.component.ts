import { Component } from '@angular/core';

@Component({
  selector: 'app-sos',
  templateUrl: './sos.component.html',
  styleUrls: ['./sos.component.css']
})

export class SosComponent {

  sendMsg(){
    console.log("I'm a Victim");
  }
  
}