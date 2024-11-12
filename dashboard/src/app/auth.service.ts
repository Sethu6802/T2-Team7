import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  register(fullName: string, password: string){
    let url = "http://localhost:8072/user/register";
    let jsonRequestBody: any = {username: fullName, password: password};
    console.log("Name: " + fullName);
    console.log("Password: " + password);
  
    this.httpClient.post(url, jsonRequestBody).subscribe(
      response => {
        console.log('Registration successful:', response);
      },
      error => {
        console.error('Error during registration:', error);
      }
    );

  }

  login(fullName: string, password: string, role: string){
    let apiUrl = "http://localhost:8072/user/login";
    let jsonRequestBody: any = {username: fullName, password: password};
    console.log("Name: " + fullName);
    console.log("Password: " + password);
  
    this.httpClient.post(apiUrl, jsonRequestBody).subscribe(
      response => {
        console.log('Login successful:', response);
        if(role=='RescueTeam'){
          this.router.navigate(['/resq']);
        } else if(role=='Hospital'){
          this.router.navigate(['/hosp']);
        } else if(role=='Volunteer'){
          this.router.navigate(['/vol']);
        } else{
          this.router.navigate(['/resq']);
        }
      },
      error => {
        console.error('Error during login:', error);
      }
    );
    
  }



  private apiUrl = 'http://localhost:8072/user/login';



  getToken(): string | null {
    return localStorage.getItem('token');
  }

  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  getAuthHeaders() {
    const token = this.getToken();
    if (token) {
      return new HttpHeaders().set('Authorization', `Bearer ${token}`);
    }
    return new HttpHeaders();
  }
}
