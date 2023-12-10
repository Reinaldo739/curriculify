import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
    selector: 'app-cadastrar-experiencias',
    templateUrl: './cadastrar-experiencias.component.html',
    styleUrls: ['./cadastrar-experiencias.component.css']
})
export class CadastrarExperienciasComponent implements OnInit {
    tipoExperiencia: string = "";
    idUsuario: number = 0;

    expFormGroup: FormGroup = this.formBuilder.group({});
    
    constructor(private authService: AuthService,
        private route: ActivatedRoute,
        private router: Router,
        private formBuilder: FormBuilder,
        private toastr: ToastrService) { }
        
    ngOnInit(): void {
        this.tipoExperiencia = this.route.snapshot.params['tipo'];
        this.idUsuario = this.route.snapshot.params['idUsuario'];

        if(this.tipoExperiencia == "academica"){
            this.expFormGroup = this.formBuilder.group({                
                instituicaoEnsino: ['', [Validators.required]],
                curso: ['', Validators.required],
                dataInicio: ['', Validators.required],
                dataTermino: ['', Validators.required]
            });
        } else {
            this.expFormGroup = this.formBuilder.group({                
                empresa: ['', [Validators.required]],
                cargo: ['', Validators.required],
                dataInicio: ['', Validators.required],
                dataTermino: ['', Validators.required]
            });
        }
    }
    
    cadastrarExperiencia(){
        if(this.expFormGroup.valid){
            this.authService.CriarExpUsuario(this.idUsuario, this.tipoExperiencia, this.expFormGroup.value).subscribe(
                (response) => {
                    console.log(response);
                    if(response.sucesso){
                        this.toastr.success('Experiência cadastrada!', 'Sucesso');
                    } else {
                        this.toastr.error('Erro ao cadastrar a experiência', 'Erro');
                    }
                },
                (error) => {
                    console.log(error);
                    this.toastr.error('Erro ao cadastrar a experiência', 'Erro');
                }
            );
        }
    }
}
    