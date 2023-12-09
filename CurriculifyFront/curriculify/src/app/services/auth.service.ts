import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }
  private apiUrl = 'https://d742-2001-1284-f508-288d-99ec-660f-8297-234.ngrok.io/';
  private readonly STORAGE_KEY = 'user_authenticated';

  login(email: string, password: string): Observable<any> {
    const body = { email, password };

    return this.http.post(this.apiUrl + 'jpa/logar', body);
  }

  cadastrar(nome: string, email: string, senha: string): Observable<any> {
    const body = { nome, email, senha };

    return this.http.post(this.apiUrl + 'jpa/cadastrarUsuario', body);
  }

  logout(): void {
    localStorage.removeItem(this.STORAGE_KEY);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem(this.STORAGE_KEY) === 'true';
  }

}
