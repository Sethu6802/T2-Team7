import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-victim-status-form-modal',
  templateUrl: './victim-status-form-modal.component.html',
  styleUrls: ['./victim-status-form-modal.component.css']
})
export class VictimStatusFormModalComponent {
  @Output() close = new EventEmitter<void>(); // To close the modal
  victimStatusForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.victimStatusForm = this.fb.group({
      patientName: ['', Validators.required],
      age: ['', Validators.required],
      damageSeverity: ['', Validators.required],
      details: ['']
    });
  }

  onSubmit() {
    if (this.victimStatusForm.valid) {
      const formData = this.victimStatusForm.value;
      console.log('Form data submitted:', formData);
      // Logic to send data to the backend can be added here
      this.close.emit(); // Close modal on submission
    }
  }

  onClose() {
    this.close.emit(); // Emit close event to parent
  }
}
