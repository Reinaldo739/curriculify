package com.projeto.curriculify.ExpAcademica;

import java.time.LocalDateTime;

public class ExpAcademica {
	
	private Integer cdExpAcademica;
	private String instituicaoEnsino;
	private String curso;
	private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
	
    
    public ExpAcademica(int cdExpAcademica, String instituicaoEnsino, String curso, LocalDateTime dataInicio,
			LocalDateTime dataTermino) {
		super();
		this.cdExpAcademica = cdExpAcademica;
		this.instituicaoEnsino = instituicaoEnsino;
		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

    

	public ExpAcademica() {
		super();
	}



	public Integer getCdExpAcademica() {
		return cdExpAcademica;
	}


	public void setCdExpAcademica(int cdExpAcademica) {
		this.cdExpAcademica = cdExpAcademica;
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
