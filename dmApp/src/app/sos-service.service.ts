import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})

export class SosServiceService {

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