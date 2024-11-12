

// import { Component } from '@angular/core';
// import { ReportService } from '../report.service';  
// import { HttpParams } from '@angular/common/http';

// @Component({
//   selector: 'app-report',
//   templateUrl: './report.component.html',
//   styleUrls: ['./report.component.css']
// })
// export class ReportComponent {
//   reportData = {
//     name: '',
//     location: '',
//     message: ''
//   };
//   http: any;

//   constructor(private reportService: ReportService) {}

 
//   onSubmit() {
//     // Define query parameters
//     let params = new HttpParams()
//       .set('name', this.reportData.name)
//       .set('location', this.reportData.location)
//       .set('message', this.reportData.message);
  
//     // Send GET request with query parameters
//     this.http.get('http://localhost:8092/message/submitMessage', { params })
//       .subscribe((response: any) => {
//         console.log('Message submitted successfully', response);
//       }, (error: any) => {
//         console.error('Error sending report:', error);
//       });
//   }
  
// }
// report.component.ts
import { Component } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent {
  reportData = {
    name: '',
    location: '',
    message: ''
  };

  constructor(private http: HttpClient) {} // Ensure HttpClient is injected

  onSubmit() {
    // Define query parameters
    let params = new HttpParams()
      .set('name', this.reportData.name)
      .set('location', this.reportData.location)
      .set('message', this.reportData.message);

    // Send GET request with query parameters
    this.http.get('http://localhost:8099/message/submitMessage', { params })
      .subscribe(response => {
        console.log('Message submitted successfully', response);
      }, error => {
        console.error('Error sending report:', error);
      });
  }
}

