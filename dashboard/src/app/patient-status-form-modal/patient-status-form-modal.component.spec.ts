import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientStatusFormModalComponent } from './patient-status-form-modal.component';

describe('PatientStatusFormModalComponent', () => {
  let component: PatientStatusFormModalComponent;
  let fixture: ComponentFixture<PatientStatusFormModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientStatusFormModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PatientStatusFormModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
