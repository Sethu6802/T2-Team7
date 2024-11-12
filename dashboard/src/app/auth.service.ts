import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private httpClient: HttpClient) { }

  register(fullName: string, password: string){
    let url = "http://localhost:8072/user/register";
    let jsonRequestBody: any = {fullName: fullName, password: password};
    console.log("Name: " + fullName);
    console.log("Password: "+password);
  
    this.httpClient.post(url, jsonRequestBody).subscribe(
      response => {
        console.log('Registration successful:', response);
      },
      error => {
        console.error('Error during registration:', error);
      }
    );
  }



  private apiUrl = 'http://localhost:8072/user/login';


  login(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(this.apiUrl, { username, password });
  }

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
