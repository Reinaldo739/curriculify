package com.projeto.curriculify.ExpProfissional;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExpProfissional {
	
	@Id
	private Integer cdExpProfissional;
	private String empresa;
	private String cargo;
	private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    
	public ExpProfissional(Integer cdExpProfissional, String empresa, String cargo, LocalDateTime dataInicio,
			LocalDateTime dataTermino) {
		super();
		this.cdExpProfissional = cdExpProfissional;
		this.empresa = empresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public ExpProfissional() {
		super();
	}

	public Integer getCdExpProfissional() {
		return cdExpProfissional;
	}

	public void setCdExpProfissional(Integer cdExpProfissional) {
		this.cdExpProfissional = cdExpProfissional;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	
    
    
}
