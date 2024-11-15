import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UpdatestatusService } from '../updatestatus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-victim-status-form-modal',
  templateUrl: './victim-status-form-modal.component.html',
  styleUrls: ['./victim-status-form-modal.component.css']
})

export class VictimStatusFormModalComponent {

  @Output() close = new EventEmitter<void>(); // To close the modal
  victimStatusForm: FormGroup;

  

  constructor(private fb: FormBuilder, private updateStatusService: UpdatestatusService, private router: Router) {
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
      this.updateStatusService.admit(formData);
      this.close.emit();
    }
  }

  onClose() {
    this.router.navigate(['/resq'])
    this.close.emit(); // Emit close event to parent
  }
}
