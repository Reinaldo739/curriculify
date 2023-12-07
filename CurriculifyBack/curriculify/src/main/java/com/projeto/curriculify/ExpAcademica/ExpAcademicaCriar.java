package com.projeto.curriculify.ExpAcademica;

import java.time.LocalDateTime;

public class ExpAcademicaCriar {
	private int idUsuario;
	private String instituicaoEnsino;
	private String curso;
	private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    
    ExpAcademicaCriar(){}
    
    
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}
	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
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
