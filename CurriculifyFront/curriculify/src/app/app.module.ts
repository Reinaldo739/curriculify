import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomePipe } from './pages/home.pipe';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { CurriculoComponent } from './pages/curriculo/curriculo.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { MenuComponent } from './pages/menu/menu.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePipe,
    HomeComponent,
    LoginComponent,
    CurriculoComponent,
    SobreComponent,
    MenuComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
