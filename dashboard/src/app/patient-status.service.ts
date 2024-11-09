import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientStatus } from './PatientStatus.model';

@Injectable({
  providedIn: 'root'
})
export class PatientStatusService {

  private apiUrl = 'http://localhost:8096/patient-status/getAll';

  constructor(private http: HttpClient) { }

  getAllPatientStatuses(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl);
  }
}
