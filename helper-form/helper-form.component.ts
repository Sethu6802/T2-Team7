import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HelperService } from '../helper.service';

@Component({
  selector: 'app-helper-form',
  templateUrl: './helper-form.component.html',
  styleUrls: ['./helper-form.component.css']
})
export class HelperFormComponent {


constructor(private helperService: HelperService, private router: Router) {}

onSubmit(formData: any) {
  const helperData = {
    name: formData.name,
    availabilityStatus: formData.availabilityStatus
  };

  this.helperService.registerHelper(helperData)
    .subscribe(response => {
      console.log('Helper registered:', response);
      this.router.navigate(['/']);
    }, error => {
      console.error('Error registering helper:', error);
    });
}
}

