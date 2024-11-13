import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VictimStatusFormModalComponent } from './victim-status-form-modal.component';

describe('VictimStatusFormModalComponent', () => {
  let component: VictimStatusFormModalComponent;
  let fixture: ComponentFixture<VictimStatusFormModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VictimStatusFormModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VictimStatusFormModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
