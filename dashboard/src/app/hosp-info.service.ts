import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hospital } from './hospitalInfo.model';

@Injectable({
  providedIn: 'root'
})
export class HospInfoService {

  private apiUrl = 'http://localhost:8072/hospitalsInfo/';

  constructor(private http: HttpClient) { }

  getHospInfo(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(this.apiUrl+"all");
  }
}
