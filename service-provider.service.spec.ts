import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceProviderService {

  private apiUrl = 'http://localhost:8099/volunteer/register/service-provider'; // Backend API URL

  constructor(private http: HttpClient) { }

  registerServiceProvider(serviceProviderData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, serviceProviderData);
  }
}
