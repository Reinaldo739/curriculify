package com.projeto.curriculify.ExpAcademica;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TesteExpAcademica extends TestCase {
	
	@Test
	public void testeExpAcademica() {
		Integer cdExpAcademica = 5;
		String instituicaoEnsino = "UniCuritiba";
		String curso = "ADS";
		ExpAcademica ExpEncontrada = new ExpAcademica();
		ExpEncontrada.setCdExpAcademica(5);
		ExpEncontrada.setInstituicaoEnsino("UniCuritiba");
		ExpEncontrada.setCurso("ADS");
		ExpEncontrada.setDataInicio(LocalDateTime.now());
		ExpEncontrada.setDataTermino(LocalDateTime.now());
		assertEquals(cdExpAcademica, ExpEncontrada.getCdExpAcademica());
		assertEquals(instituicaoEnsino, ExpEncontrada.getInstituicaoEnsino());
		assertEquals(curso, ExpEncontrada.getCurso());
		assertEquals(LocalDateTime.now(), ExpEncontrada.getDataInicio());
		assertEquals(LocalDateTime.now(), ExpEncontrada.getDataTermino());
		
	}

}
