import { Component } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';
import { PatientStatus } from '../PatientStatus.model';
import { PatientStatusService } from '../patient-status.service';

@Component({
  selector: 'app-hosp',
  templateUrl: './hosp.component.html',
  styleUrl: './hosp.component.css'
})

export class HospComponent {

  patients: Patient[] = [];
  patient_status: PatientStatus[] = [];
  yet_to_be_patients: PatientStatus[] = [];

  constructor(
    private patientService: PatientService, 
    private patientStatusService: PatientStatusService
  ) { }

  ngOnInit(): void {
    this.patientService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });

    this.patientStatusService.getAllPatientStatuses().subscribe(
      next=> (stranger: PatientStatus[]) => {
        this.patient_status = stranger;
      },
      error=> {
        console.error("Error Occurred: " + error);
      }
    );

    this.patientStatusService.getNotAdmittedPatients().subscribe(
      next=> (someone: PatientStatus[]) => {
        this.yet_to_be_patients = someone;
      },
      error=>{
        console.error("Error Occurred: " + error);
      }
    )

  }
}
