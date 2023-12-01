import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  private apiUrl = 'http://localhost:8080/';
  private readonly STORAGE_KEY = 'user_authenticated';
  
  login(email: string, password: string): Observable<any> {
    const body = { email, password };
    console.log(body)

    return this.http.post(this.apiUrl + 'jpa/usuarios/login', body);
  }


  logout(): void {
    localStorage.removeItem(this.STORAGE_KEY);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem(this.STORAGE_KEY) === 'true';
  }

}
