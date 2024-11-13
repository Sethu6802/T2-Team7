import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vol',
  templateUrl: './vol.component.html',
  styleUrl: './vol.component.css'
})
export class VolComponent {
  constructor(private router: Router) {}

  navigateToHelperForm() {
    this.router.navigate(['/helper-form']);
  }
  navigateToServiceProviderForm() {
    this.router.navigate(['/register-service-provider']);
  }

 
}


