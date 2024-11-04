import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  register(fullName: string, roles: string){
    let url = "https://localhost:9078/auth/register";
    let jsonRequestBody: any = {fullName: fullName, roles: roles};
    console.log("Name: " + fullName);
    console.log("Role: " + roles);
  
    return this.httpClient.post(url,jsonRequestBody);
  }
}
