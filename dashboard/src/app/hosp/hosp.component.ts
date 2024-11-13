import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';
import { PatientStatus } from '../PatientStatus.model';
import { PatientStatusService } from '../patient-status.service';

@Component({
  selector: 'app-hosp',
  templateUrl: './hosp.component.html',
  styleUrls: ['./hosp.component.css'] // Use styleUrls to support an array syntax
})

export class HospComponent implements OnInit {
  patients: Patient[] = [];
  patient_status: PatientStatus[] = [];
  yet_to_be_patients: PatientStatus[] = [];
  showAddStatusForm: boolean = false; // Property to control modal visibility

  constructor(
    private patientService: PatientService, 
    private patientStatusService: PatientStatusService
  ) { }

  ngOnInit(): void {
    this.patientService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });

    this.patientStatusService.getAllPatientStatuses().subscribe(
      (stranger: PatientStatus[]) => {
        this.patient_status = stranger;
      }
    );

    this.patientStatusService.getNotAdmittedPatients().subscribe(
      (someone: PatientStatus[]) => {
        this.yet_to_be_patients = someone;
      }
    );
  }

  // Method to open the Victim Status form modal
  openAddStatusForm() {
    this.showAddStatusForm = true;
  }

  // Method to close the Victim Status form modal
  closeAddStatusForm() {
    this.showAddStatusForm = false;
  }
}
