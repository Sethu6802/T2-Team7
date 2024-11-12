import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HelperService {
  private baseUrl = 'http://localhost:8099/volunteer';

  constructor(private http: HttpClient) {}

  registerHelper(helperData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register/helper`, helperData);
  }
}
