import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientStatus } from './PatientStatus.model';

@Injectable({
  providedIn: 'root'
})

export class PatientStatusService {
  addPatientStatus(formData: any) {
    throw new Error('Method not implemented.');
  }

  private apiUrl = 'http://localhost:8096/patient-status/getAll';
  private url2 = 'http://localhost:8096/patient-status/getNotAdmitted';
 
  constructor(private http: HttpClient) { }

  getAllPatientStatuses(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl);
  }

  getNotAdmittedPatients(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.url2);
  }
  
  
}
