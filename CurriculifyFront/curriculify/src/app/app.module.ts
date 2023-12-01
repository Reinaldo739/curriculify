import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { CurriculoComponent } from './pages/curriculo/curriculo.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { MenuComponent } from './pages/menu/menu.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router'; // Adicione esta linha
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CurriculoComponent,
    SobreComponent,
    MenuComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-center',
      preventDuplicates: true,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
