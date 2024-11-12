// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class ReportService {

//   constructor() { }
// }

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private apiUrl = 'http://localhost:8092/message//submitMessage';

  constructor(private http: HttpClient) {}

  sendReport(data: { name: string; location: string; message: string }): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get(this.apiUrl, {
      headers,
      params: {
        location: data.location,
        clientIp: '127.0.0.1'  // Mock IP for testing; normally, it would be auto-set by the server.
      }
    });
  }
}

