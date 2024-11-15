import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  private apiUrl4 = 'http://localhost:8096/patient-status/update/{id}';
 
  constructor(private http: HttpClient) { }

  getAllPatientStatuses(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl);
  }

  getNotAdmittedPatients(): Observable<PatientStatus[]> {
    return this.http.get<PatientStatus[]>(this.apiUrl2);
  }
  
  addPatientStatus(formData: any) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<PatientStatus[]>(this.apiUrl3, JSON.stringify(formData), { headers: headers });
  }

  updatePatientStatus(patientId: number, formData: any): Observable<PatientStatus> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.put<PatientStatus>(`${this.apiUrl4}/${patientId}`, JSON.stringify(formData), { headers: headers });
  }

}
