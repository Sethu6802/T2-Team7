import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResqPageComponent } from './resq-page.component';

describe('ResqPageComponent', () => {
  let component: ResqPageComponent;
  let fixture: ComponentFixture<ResqPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResqPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResqPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
