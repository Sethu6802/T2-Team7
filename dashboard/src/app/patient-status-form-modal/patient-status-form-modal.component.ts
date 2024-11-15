import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PatientStatusService } from '../patient-status.service';  // Assuming the service is already created
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient-status-form-modal',
  templateUrl: './patient-status-form-modal.component.html',
  styleUrls: ['./patient-status-form-modal.component.css']
})

export class PatientStatusFormModalComponent {

  @Output() close = new EventEmitter<void>();
  @Input() patientId: number | null = null;
  patientStatusForm: FormGroup;

  constructor(private fb: FormBuilder, private patientStatusService: PatientStatusService, private router: Router) {

    this.patientStatusForm = this.fb.group({
      id: ['', Validators.required],
      statusUpdatedTime: Date,
      status: ['', Validators.required],
      notes: ['']
    });
  }


  onSubmit() {
    if (this.patientStatusForm.valid) {
      const formData = this.patientStatusForm.value;
      if (this.patientId) {
        this.patientStatusService.updatePatientStatus(this.patientId, formData).subscribe(response => {
          console.log('Patient status updated:', response);
        });
      } else {
        this.patientStatusService.addPatientStatus(formData).subscribe(response => {
          console.log('New patient status added:', response);
        });
      }
    }
    this.router.navigate(['/hosp']);
  }

  onClose() {
    this.patientStatusForm.reset();
    this.router.navigate(['/hosp']);
    this.close.emit();
  }
}
