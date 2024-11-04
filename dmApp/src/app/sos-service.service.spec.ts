import { TestBed } from '@angular/core/testing';

import { SosServiceService } from './sos-service.service';

describe('SosServiceService', () => {
  let service: SosServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SosServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
