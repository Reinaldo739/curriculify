import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarExperienciasComponent } from './cadastrar-experiencias.component';

describe('CadastrarExperienciasComponent', () => {
  let component: CadastrarExperienciasComponent;
  let fixture: ComponentFixture<CadastrarExperienciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrarExperienciasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarExperienciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
