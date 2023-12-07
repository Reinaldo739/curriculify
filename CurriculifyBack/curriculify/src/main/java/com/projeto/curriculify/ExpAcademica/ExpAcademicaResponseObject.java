package com.projeto.curriculify.ExpAcademica;

import java.time.LocalDateTime;

public class ExpAcademicaResponseObject {
	public boolean sucesso;
	public Integer id;
	
	ExpAcademicaResponseObject(boolean sucesso, Integer id) {
		this.sucesso = sucesso;
		this.id = id;	
	}
}



