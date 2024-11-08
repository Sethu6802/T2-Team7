import { Component } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-hosp',
  templateUrl: './hosp.component.html',
  styleUrl: './hosp.component.css'
})
export class HospComponent {
  patients: Patient[] = [];

  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.patientService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });
  }
}
