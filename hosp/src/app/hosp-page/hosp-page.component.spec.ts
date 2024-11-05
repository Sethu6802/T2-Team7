import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospPageComponent } from './hosp-page.component';

describe('HospPageComponent', () => {
  let component: HospPageComponent;
  let fixture: ComponentFixture<HospPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HospPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
