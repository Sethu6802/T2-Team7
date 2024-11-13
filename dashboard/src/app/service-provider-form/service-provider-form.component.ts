import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceProviderService } from '../service-provider.service'; // Update with correct path

@Component({
  selector: 'app-service-provider-form',
  templateUrl: './service-provider-form.component.html',
  styleUrls: ['./service-provider-form.component.css']
})
export class ServiceProviderFormComponent {
  constructor(private serviceProviderService: ServiceProviderService, private router: Router) {}

  onSubmit(serviceProviderForm: any) {
    const serviceProviderData = {
      name: serviceProviderForm.value.name,
      serviceType: serviceProviderForm.value.serviceType,
      available: serviceProviderForm.value.available === 'true' // Convert string to boolean
    };

    // Here we can safely subscribe because `registerServiceProvider` returns an observable
    this.serviceProviderService.registerServiceProvider(serviceProviderData)
      .subscribe((response: any) => {
        console.log('Service Provider registered:', response);
        this.router.navigate(['/']); // Redirect after successful registration
      }, (error: any) => {
        console.error('Error registering Service Provider:', error);
      });
  }
}
