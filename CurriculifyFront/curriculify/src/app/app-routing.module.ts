import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { SobreComponent } from './pages/sobre/sobre.component';
import { LoginGuard } from './pages/guards/login.guard';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [LoginGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'sobre', component: SobreComponent },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
})
export class AppRoutingModule {}
