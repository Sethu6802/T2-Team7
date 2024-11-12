import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  username: string = '';
  password: string = '';
  role: string = '';

  constructor(private authService: AuthService) {}
  
  onLogin() {
    this.authService.login(this.username,this.password,this.role);
  }
}
