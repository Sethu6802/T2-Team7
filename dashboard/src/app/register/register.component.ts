import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class registerComponent {
  fullName: string = '';
  roles: string = '';

  constructor(private authService: AuthService){}

  onSubmit(){
    this.authService.register(this.fullName,this.roles);
  }
}
