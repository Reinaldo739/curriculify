import { Component, OnInit, AfterViewInit  } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit {
    usuarioEmail: String = "";
    usuarioNome: String = "";
    expAcademicas: any[] = [];
    expProfissionais: any[] = [];

    constructor(private authService: AuthService,
                private route: ActivatedRoute,
                private router: Router) { }
    
    ngAfterViewInit(): void {
        
    }

    ngOnInit(): void {
        var idUsuario = this.route.snapshot.params['idUsuario'];

        this.authService.PegarDadosUsuario(idUsuario).subscribe(
            (response) => {
                this.usuarioEmail = response.email;
                this.usuarioNome = response.nome;
            },
            (error) => {
                console.log(error);
            }
        );

        this.authService.PegarExpAcademicasUsuario(idUsuario).subscribe(
            (response) => {
                this.expAcademicas = response;

                for (let key in this.expAcademicas) {
                    this.expAcademicas[key].dataInicio = this.converterDataUSparaBR(this.expAcademicas[key].dataInicio);
                    this.expAcademicas[key].dataTermino = this.converterDataUSparaBR(this.expAcademicas[key].dataTermino);
                }
            },
            (error) => {
                console.log(error);
            }
        );

        this.authService.PegarExpProfissionaisUsuario(idUsuario).subscribe(
            (response) => {
                this.expProfissionais = response;

                for (let key in this.expProfissionais) {
                    this.expProfissionais[key].dataInicio = this.converterDataUSparaBR(this.expProfissionais[key].dataInicio);
                    this.expProfissionais[key].dataTermino = this.converterDataUSparaBR(this.expProfissionais[key].dataTermino);
                }
            },
            (error) => {
                console.log(error);
            }
        );
    }

    converterDataUSparaBR(inputDate: string): string | null {
        const isoDatePattern = /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}$/;
        
        if (!isoDatePattern.test(inputDate)) {
            console.error('Invalid date format');
            return null;
        }
        
        const isoDate = new Date(inputDate);
        
        // Use a helper function to ensure two-digit formatting
        const formatTwoDigits = (value: number) => value.toString().padStart(2, '0');
        
        const day = formatTwoDigits(isoDate.getDate());
        const month = formatTwoDigits(isoDate.getMonth() + 1); // Months are zero-based
        const year = isoDate.getFullYear();
        
        return `${day}/${month}/${year}`;
    }

    gerarHtmlCurriculo(): string {
        var html = "<body>";

        var dados = `<h1>Dados Cadastrais</h1>
<p>Nome: ${this.usuarioNome}</p>
<p>Email:${this.usuarioEmail}</p>
-----------------------------------------------------------------------------------------------------------------------`;
        html+=dados;

        var expAcademicas = "";
        if(this.expAcademicas.length !== 0){
            expAcademicas = "<h2>Experiência Acadêmica</h2>\n"; 
            this.expAcademicas.forEach(value => {
                var dataInicio = value['dataInicio'];
                var dataTermino = value['dataTermino'];
                var instituicaoEnsino = value['instituicaoEnsino'];
                var curso = value['curso'];
    
                expAcademicas += `<div style="width: 100%; margin-bottom: 10px;">
        <div>${dataInicio} - ${dataTermino}</div>
        <div>${instituicaoEnsino} - ${curso}</div>
    </div>
`;
            });
        }

        var expProfissionais = "";
        if(this.expProfissionais.length !== 0){
            expProfissionais = "<h2>Experiência Profissional</h2>\n"; 
            this.expProfissionais.forEach(value => {
                var dataInicio = value['dataInicio'];
                var dataTermino = value['dataTermino'];
                var empresa = value['empresa'];
                var cargo = value['cargo'];
    
                expProfissionais += `<div style="width: 100%; margin-bottom: 10px;">
        <div>${dataInicio} - ${dataTermino}</div>
        <div>${empresa} - ${cargo}</div>
    </div>
`;
            });
        }

        html += expAcademicas;
        html += expProfissionais;

        if(expAcademicas == "" && expProfissionais == ""){
            html += "<h3>Sem experiência</h3>";
        }

        html += "</body>";

        return html;
    }

    onClickBtnGerarCurriculo() {
        this.authService.GerarCurriculo(this.route.snapshot.params['idUsuario'], this.gerarHtmlCurriculo()).subscribe(
            (response: Blob) => {
                // Create a Blob from the response
                const blob = new Blob([response], { type: 'application/pdf' });

                // Create a download link
                const downloadLink = document.createElement('a');
                downloadLink.href = window.URL.createObjectURL(blob);
                downloadLink.download = 'curriculo.pdf';

                // Append the link to the body and trigger a click event
                document.body.appendChild(downloadLink);
                downloadLink.click();

                // Clean up
                document.body.removeChild(downloadLink);
            },
            (error) => {
                console.log(error);
            }
        );
    }

    navegarNovaExperienciaAcademica(){
        this.router.navigate(['/cadastrar-experiencias', {idUsuario: this.route.snapshot.params['idUsuario'], tipo: "academica"}]);
    }

    navegarNovaExperienciaProfissional(){
        this.router.navigate(['/cadastrar-experiencias', {idUsuario: this.route.snapshot.params['idUsuario'], tipo: "profissional"}]);
    }
}
