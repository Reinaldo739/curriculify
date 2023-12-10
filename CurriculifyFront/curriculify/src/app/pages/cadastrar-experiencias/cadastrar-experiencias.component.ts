import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
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
                dataInicio: ['', Validators.required, this.verificarPadraoData()],
                dataTermino: ['', Validators.required, this.verificarPadraoData()]
            });
        } else {
            this.expFormGroup = this.formBuilder.group({                
                empresa: ['', [Validators.required]],
                cargo: ['', Validators.required],
                dataInicio: ['', Validators.required, this.verificarPadraoData()],
                dataTermino: ['', Validators.required, this.verificarPadraoData()]
            });
        }
    }

    converterDataBRparaUS(inputDate: string): string | null {
        // Check if the input date is in the correct format
        const datePattern = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;
        if (!datePattern.test(inputDate)) {
            console.error('Invalid date format');
            return null;
        }
        
        // Parse the input date
        const [day, month, year] = inputDate.split('/').map(Number);
        
        // Create a Date object with the parsed values
        const formattedDate = new Date(year, month - 1, day);
        
        // Get the formatted date string
        const isoDateString = formattedDate.toISOString().split('T')[0];
        
        // Return the result in the desired format
        return `${isoDateString}T00:00:00`;
    }
    
    cadastrarExperiencia(){
        if(this.expFormGroup.valid){
            this.expFormGroup.value.dataInicio = this.converterDataBRparaUS(this.expFormGroup.value.dataInicio);
            this.expFormGroup.value.dataTermino = this.converterDataBRparaUS(this.expFormGroup.value.dataTermino);

            this.authService.CriarExpUsuario(this.idUsuario, this.tipoExperiencia, this.expFormGroup.value).subscribe(
                (response) => {
                    console.log(response);
                    if(response.sucesso){
                        this.toastr.success('Experiência cadastrada!', 'Sucesso');
                        this.router.navigate(['/home', {idUsuario: this.idUsuario}]);
                    } else {
                        this.toastr.error('Erro ao cadastrar a experiência', 'Erro');
                    }
                },
                (error) => {
                    console.log(error);
                    this.toastr.error('Erro ao cadastrar a experiência', 'Erro');
                }
            );
        } else {
            this.toastr.error('Verifique os campos!', 'Erro');
        }
    }

    verificarPadraoData(): ValidatorFn {
        const datePattern = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/\d{4}$/;
        
        return (control: AbstractControl): Promise<{ [key: string]: any } | null> | null => {
            const value = control.value;
            
            if (Validators.required(control) !== null) {
                // If the control is required, let the required validator handle it
                return Promise.resolve(null);
            }
            
            if (!datePattern.test(value)) {
                return Promise.resolve({ 'invalidDate': { value } });
            }
            
            // Date format is valid
            return Promise.resolve(null);
        };
    }
}
    