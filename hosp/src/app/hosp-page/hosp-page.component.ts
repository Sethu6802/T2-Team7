import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient.model';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-hosp-page',
  templateUrl: './hosp-page.component.html',
  styleUrls: ['./hosp-page.component.css']
})

export class HospPageComponent implements OnInit{

  patients: Patient[] = [];

  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.patientService.getPatients().subscribe((data: Patient[]) => {
      this.patients = data;
    });
  }

}