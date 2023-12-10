package com.projeto.curriculify.ExpProfissional;

import java.time.LocalDateTime;
import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ExpProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idUsuario;
	private String empresa;
	private String cargo;
	private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    
	public ExpProfissional(Integer idUsuario, String empresa, String cargo, LocalDateTime dataInicio, LocalDateTime dataTermino) {
		super();
		this.idUsuario = idUsuario;
		this.empresa = empresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public ExpProfissional() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


    
}
