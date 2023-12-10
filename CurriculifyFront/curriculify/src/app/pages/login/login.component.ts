// login.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup = this.formBuilder.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required]
    });
    
    constructor(
        private formBuilder: FormBuilder,
        private authService: AuthService,
        private router: Router,
        private toastr: ToastrService
        ) { }
        
    ngOnInit(): void {
    }
        
    login(): void {
        if (this.loginForm.valid) {
            const { email, password } = this.loginForm.value;
            this.authService.login(email, password).subscribe(
                (response) => {
                    if(!response.sucesso){
                        switch(response.msg){
                            case "CREDENCIAL_INVALIDA":
                                this.toastr.error('Credenciais inválidas', 'Erro');
                                break;
                            default:
                                this.toastr.error('Erro desconhecido', 'Erro');
                                break;
                        }
                    } else {
                        this.toastr.success('Usuário logado!', 'Sucesso');
                        this.router.navigate(['/home', {idUsuario: response.idUsuario}]);
                    }
                },
                (error) => {
                    console.error('Erro ao fazer login:', error);
                }
            );
        } else {
            Object.keys(this.loginForm.controls).forEach(key => {
                this.loginForm.get(key)?.markAsTouched();
            });
        }
    }
            
    cadastrar(): void {
        this.router.navigate(['/cadastro']);
    }
}
        