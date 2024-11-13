import { TestBed } from '@angular/core/testing';

import { PatientStatusService } from './patient-status.service';

describe('PatientStatusService', () => {
  let service: PatientStatusService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatientStatusService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
