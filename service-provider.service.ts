import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';  // Ensure you import Observable from rxjs

@Injectable({
  providedIn: 'root'
})
export class ServiceProviderService {

  private apiUrl = 'http://localhost:8099/volunteer/register/service-provider'; // Your backend API URL

  constructor(private http: HttpClient) { }

  // Ensure this method returns an Observable
  registerServiceProvider(serviceProviderData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, serviceProviderData);
  }
}
