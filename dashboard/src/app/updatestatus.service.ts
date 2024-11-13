import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class UpdatestatusService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  admit(formData: any){
    let url = "http://localhost:8072/hospital/admit";
  
    this.httpClient.post(url, formData).subscribe(
      response => {
        console.log('Updated successful:', response);
      },
      error => {
        console.error('Error during updation:', error);
      }
    );

    this.router.navigate(['/resq']);

  }

}
