import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient.model';
import { PatientStatus } from './PatientStatus.model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  updateVictimStatus(arg0: any) {
    throw new Error('Method not implemented.');
  }

  private apiUrl = 'http://localhost:8094/hospital/patients';

  constructor(private http: HttpClient) { }

  getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.apiUrl);
  }
  addPatientStatus(patientStatus: PatientStatus): Observable<PatientStatus> {
    return this.http.post<PatientStatus>(`${this.apiUrl}/add`, patientStatus);
  }
  
}
