import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  register(fullName: string, roles: string){
    let url = "http://localhost:9078/auth/register";
    let jsonRequestBody: any = {fullName: fullName, roles: roles};
    console.log("Name: " + fullName);
    console.log("Role: " + roles);
  
    this.httpClient.post(url, jsonRequestBody).subscribe(
      response => {
        console.log('Registration successful:', response);
      },
      error => {
        console.error('Error during registration:', error);
      }
    );
    
  }
}
