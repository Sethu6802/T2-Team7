import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { sosMessage } from './SosMessage.model';

@Injectable({
  providedIn: 'root'
})
export class SosListService {

  private apiUrl = 'http://localhost:8092/sendAllMessages';

  constructor(private http: HttpClient) { }

  getSosList(): Observable<sosMessage[]> {
    return this.http.get<sosMessage[]>(this.apiUrl);
  }
}
