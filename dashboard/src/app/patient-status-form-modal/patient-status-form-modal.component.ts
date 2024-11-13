import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PatientStatusService } from '../patient-status.service';  // Assuming the service is already created

@Component({
  selector: 'app-patient-status-form-modal',
  templateUrl: './patient-status-form-modal.component.html',
  styleUrls: ['./patient-status-form-modal.component.css']
})
export class PatientStatusFormModalComponent {
  @Output() close = new EventEmitter<void>(); // Event emitter to close the modal
  patientStatusForm: FormGroup;

  constructor(private fb: FormBuilder, private patientStatusService: PatientStatusService) {
    // Define the form controls and validations
    this.patientStatusForm = this.fb.group({
      patientId: ['', Validators.required],  // Make patientId required
      status: ['', Validators.required],  // Make status required
      notes: ['']  // Optional field
    });
  }

  // Handle form submission
  onSubmit() {
    if (this.patientStatusForm.valid) {
      const formData = this.patientStatusForm.value;
      this.patientStatusService.addPatientStatus(formData).subscribe(() => {
        console.log('Patient status updated:', formData);
        this.patientStatusForm.reset(); // Reset the form after successful submission
        this.close.emit(); // Emit event to close modal
      });
    }
  }

  // Handle modal close
  onClose() {
    this.patientStatusForm.reset(); // Clear form
    this.close.emit(); // Emit event to close modal
  }
}
