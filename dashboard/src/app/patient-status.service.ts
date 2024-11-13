import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientStatus } from './PatientStatus.model';

@Injectable({
  providedIn: 'root'
})

export class PatientStatusService {
  

  private apiUrl = 'http://localhost:8096/patient-status/getAll';
  private apiUrl2 = 'http://localhost:8096/patient-status/getNotAdmitted';
  private apiUrl3 = 'http://localhost:8096/patient-status/add';
 
  constructor(private http: HttpClient) { }

  getAllPatientStatuses(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl);
  }

  getNotAdmittedPatients(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl2);
  }
  
  addPatientStatus(formData: any) {
    return this.http.post<PatientStatus[]>(this.apiUrl3, formData);
  }

}
