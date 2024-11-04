import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})

export class FormComponent {

  fullName: string = '';
  roles: string = '';

  constructor(private authService: AuthService){}

  onSubmit(){
    this.authService.register(this.fullName,this.roles);
  }

}