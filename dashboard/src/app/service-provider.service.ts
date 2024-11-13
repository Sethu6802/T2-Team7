import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ServiceProviderService {

  private apiUrl = 'http://localhost:8072/volunteer/register/service-provider';

  constructor(private http: HttpClient) { }

  registerServiceProvider(serviceProviderData: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, serviceProviderData);
  }
}
