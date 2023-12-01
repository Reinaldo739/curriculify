import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router'; // Adicione esta linha
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { LoginGuard } from './pages/guards/login.guard';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [LoginGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'login', component: LoginComponent, canActivate: [LoginGuard] },
  { path: 'home', component: HomeComponent, canActivate: [LoginGuard] },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'sobre', component: SobreComponent, canActivate: [LoginGuard] },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes), // Adicione esta linha
  ],
})
export class AppRoutingModule {}
