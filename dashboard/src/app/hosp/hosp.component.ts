import { Component } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';
import { PatientStatus } from '../PatientStatus.model';
import { PatientStatusService } from '../patient-status.service';
import { SosListService } from '../sos-list.service';
import { sosMessage } from '../SosMessage.model';

@Component({
  selector: 'app-hosp',
  templateUrl: './hosp.component.html',
  styleUrl: './hosp.component.css'
})

export class HospComponent {

  patients: Patient[] = [];
  patient_status: PatientStatus[] = [];

  constructor(
    private patientService: PatientService, 
    private patientStatusService: PatientStatusService
  ) { }

  ngOnInit(): void {
    this.patientService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });

    this.patientStatusService.getAllPatientStatuses().subscribe(
      (st: PatientStatus[]) => {
        this.patient_status = st;
      }
    );

  }
}
