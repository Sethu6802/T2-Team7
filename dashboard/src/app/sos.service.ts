import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SosService {

  constructor(private http: HttpClient) {}

  sendMessage(){
    let url = 'http://localhost:8092/sendMessage';
    // const headers = new HttpHeaders({
    //   'X-Forwarded-For': '8.8.8.8' 
    // });
    
    // return this.http.get(url, { headers });

    return this.http.get(url);
  }
  
}
