import { Component, OnInit, AfterViewInit  } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit {
    usuarioEmail: String = "";
    usuarioNome: String = "";
    expAcademicas = [];
    expProfissionais = [];

    constructor(private authService: AuthService,
                private route: ActivatedRoute) { }
    
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
            },
            (error) => {
                console.log(error);
            }
        );

        this.authService.PegarExpProfissionaisUsuario(idUsuario).subscribe(
            (response) => {
                this.expProfissionais = response;
            },
            (error) => {
                console.log(error);
            }
        );
    }

    onClickBtnGerarCurriculo() {
        this.authService.GerarCurriculo(this.route.snapshot.params['idUsuario'], "<p>Hello World!</p>").subscribe(
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
}
