import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  
  private apiUrl = 'http://localhost:8080/api/usuarios/nombre/';

  private userDataSubject = new BehaviorSubject<any>(null);
  userData$ = this.userDataSubject.asObservable();

  constructor(
    private http: HttpClient
  ) {}

  getUserData(username: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}${username}`).pipe(
      tap(data => {this.userDataSubject.next(data); console.log(data)})
      
    );
  };

}
