// cadastro.component.ts
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { ToastrService } from 'ngx-toastr'; // Certifique-se de importar o ToastrService

@Component({
    selector: 'app-cadastro',
    templateUrl: './cadastro.component.html',
    styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
    cadastroForm: FormGroup = this.formBuilder.group({
        nome: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        senha: ['', Validators.required],
        confirmarSenha: ['', Validators.required]
    }, { validators: this.confirmarSenhaValidator });
    
    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private authService: AuthService,
        private toastr: ToastrService
        ) { }
        
    ngOnInit(): void {
    }
        
    cadastrar(): void {
        if (this.cadastroForm.valid) {
            const { nome, email, senha } = this.cadastroForm.value;
            
            this.authService.cadastrar(nome, email, senha).subscribe(
                (response) => {
                    console.log('Resposta do backend:', response);
                    
                    if(response.sucesso){
                        this.toastr.success('Cadastro realizado com sucesso!', 'Sucesso');
                        this.router.navigate(['/login']);
                    } else {
                        switch(response.msg){
                            case 'USUARIO_JA_EXISTE':
                                this.toastr.error('Esse email já é cadastrado!', 'Erro');
                                break;
                            default:
                                this.toastr.error('Erro desconhecido!', 'Erro');
                                break;
                        }
                    }
                },
                (error) => {
                    console.error('Erro ao cadastrar:', error);
                    this.toastr.error('Erro ao cadastrar. Tente novamente mais tarde.', 'Falha no cadastro');
                }
            );
        } else {
            this.cadastroForm.markAllAsTouched();
        }
    }
        
    confirmarSenhaValidator(formGroup: FormGroup) {
        const senha = formGroup.get('senha')?.value;
        const confirmarSenha = formGroup.get('confirmarSenha')?.value;
        
        return senha === confirmarSenha ? null : { senhaMatch: true };
    }
}
        