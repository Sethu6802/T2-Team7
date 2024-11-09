import { Component } from '@angular/core';
import { sosMessage } from '../SosMessage.model';
import { SosListService } from '../sos-list.service';
import { PatientStatus } from '../PatientStatus.model';
import { PatientStatusService } from '../patient-status.service';
import { Hospital } from '../hospitalInfo.model';
import { HospInfoService } from '../hosp-info.service';

@Component({
  selector: 'app-resq',
  templateUrl: './resq.component.html',
  styleUrl: './resq.component.css'
})

export class ResqComponent {
  
  sos_list: sosMessage[] = [];
  patient_status: PatientStatus[] = [];
  hosp: Hospital[] = [];

  constructor(
    private soslistService: SosListService,
    private patientStatusService: PatientStatusService,
    private hospInfoService: HospInfoService
  ){}

  ngOnInit(): void {
    this.soslistService.getSosList().subscribe(
      (item: sosMessage[]) => {
        console.log(item);
        this.sos_list = item;
      }
    )

    this.patientStatusService.getAllPatientStatuses().subscribe(
      (st: PatientStatus[]) => {
        this.patient_status = st;
      }
    );

    this.hospInfoService.getHospInfo().subscribe(
      (i: Hospital[]) => {
        this.hosp = i;
      }
    )
  }
}
