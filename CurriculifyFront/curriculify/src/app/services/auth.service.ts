import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    
    constructor(private http: HttpClient) { }
    private apiUrl = 'http://localhost:8080/';
    private readonly STORAGE_KEY = 'user_authenticated';
    
    // Usuario ------------------------------------------------------------------
    login(email: string, senha: string): Observable<any> {
        const body = { email, senha };
        return this.http.post(this.apiUrl + 'logar', body);
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

    PegarDadosUsuario(idUsuario: number): Observable<any> {
        let params = new HttpParams()
            .set('idUsuario', idUsuario);

        return this.http.get(this.apiUrl + 'dadosUsuario', {params: params});
    }

    // ExpAcademica ------------------------------------------------------------------
    PegarExpAcademicasUsuario(idUsuario: number): Observable<any> {
        let params = new HttpParams()
            .set('idUsuario', idUsuario);

        return this.http.get(this.apiUrl + 'jpa/ExpAcademica', {params: params});
    }

    // ExpProfissional ------------------------------------------------------------------

    PegarExpProfissionaisUsuario(idUsuario: number): Observable<any> {
        let params = new HttpParams()
            .set('idUsuario', idUsuario);

        return this.http.get(this.apiUrl + 'jpa/ExpProfissional', {params: params});
    }

    // Gerar Curriculo ------------------------------------------------------------------

    GerarCurriculo(idUsuario: number, html: string): Observable<any> {
        const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        let params = new HttpParams()
            .set('idUsuario', idUsuario);

        return this.http.post(this.apiUrl + 'jpa/criarCurriculo', html, {params: params, headers, responseType: 'blob'},);
    }    
}
