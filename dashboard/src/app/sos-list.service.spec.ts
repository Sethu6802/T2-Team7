import { TestBed } from '@angular/core/testing';

import { SosListService } from './sos-list.service';

describe('SosListService', () => {
  let service: SosListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SosListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
