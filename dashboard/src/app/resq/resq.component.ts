// import { Component } from '@angular/core';
// import { sosMessage } from '../SosMessage.model';
// import { SosListService } from '../sos-list.service';
// import { PatientStatus } from '../PatientStatus.model';
// import { PatientStatusService } from '../patient-status.service';
// import { Hospital } from '../hospitalInfo.model';
// import { HospInfoService } from '../hosp-info.service';

// @Component({
//   selector: 'app-resq',
//   templateUrl: './resq.component.html',
//   styleUrl: './resq.component.css'
// })

// export class ResqComponent {
  
//   sos_list: sosMessage[] = [];
//   patient_status: PatientStatus[] = [];
//   hosp: Hospital[] = [];

//   constructor(
//     private soslistService: SosListService,
//     private patientStatusService: PatientStatusService,
//     private hospInfoService: HospInfoService
//   ){}

//   ngOnInit(): void {
//     this.soslistService.getSosList().subscribe(
//       (item: sosMessage[]) => {
//         console.log(item);
//         this.sos_list = item;
//       }
//     )

//     this.patientStatusService.getAllPatientStatuses().subscribe(
//       (st: PatientStatus[]) => {
//         this.patient_status = st;
//       }
//     );

//     this.hospInfoService.getHospInfo().subscribe(
//       (i: Hospital[]) => {
//         this.hosp = i;
//       }
//     )
//   }
// }
import { Component, OnInit } from '@angular/core';
import { sosMessage } from '../SosMessage.model';
import { SosListService } from '../sos-list.service';
import { PatientStatus } from '../PatientStatus.model';
import { PatientStatusService } from '../patient-status.service';
import { Hospital } from '../hospitalInfo.model';
import { HospInfoService } from '../hosp-info.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resq',
  templateUrl: './resq.component.html',
  styleUrls: ['./resq.component.css'] // Note the change to 'styleUrls' for array syntax
})
export class ResqComponent implements OnInit {
  sos_list: sosMessage[] = [];
  patient_status: PatientStatus[] = [];
  hosp: Hospital[] = [];
  
  showAddStatusForm: boolean = false; // Property to control modal visibility

  constructor(
    private soslistService: SosListService,
    private patientStatusService: PatientStatusService,
    private hospInfoService: HospInfoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.soslistService.getSosList().subscribe({
      next: (sosMessages: any[]) => {
        console.log(sosMessages);
        this.sos_list = sosMessages;
      },
      error: (err) => {
        console.error('Error fetching SOS list:', err);
      }
    });
    

    this.patientStatusService.getAllPatientStatuses().subscribe({
      next: (patientStatuses: PatientStatus[]) => {
        this.patient_status = patientStatuses;
      },
      error: (err) => {
        console.error('Error fetching patient statuses:', err);
      }
    });

    this.hospInfoService.getHospInfo().subscribe({
      next: (hospitalInfo: Hospital[]) => {
        this.hosp = hospitalInfo;
      },
      error: (err) => {
        console.error('Error fetching hospital info:', err);
      }
    });
  }

  openAddStatusForm(){
    this.showAddStatusForm = true;
  }

  closeAddStatusForm(){
    this.showAddStatusForm = false;
  }
}
