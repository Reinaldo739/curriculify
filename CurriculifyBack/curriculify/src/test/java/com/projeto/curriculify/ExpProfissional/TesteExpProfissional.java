package com.projeto.curriculify.ExpProfissional;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TesteExpProfissional extends TestCase {
	
	@Test
	public void testeExpAcademica() {
		Integer cdExpProfissional = 5;
		String empresa = "UniCuritiba";
		String cargo = "Professor";
		ExpProfissional ExpEncontrada = new ExpProfissional();
		ExpEncontrada.setId(5);
		ExpEncontrada.setEmpresa("UniCuritiba");
		ExpEncontrada.setCargo("Professor");
		ExpEncontrada.setDataInicio(LocalDateTime.now());
		ExpEncontrada.setDataTermino(LocalDateTime.now());
		assertEquals(cdExpProfissional, ExpEncontrada.getId());
		assertEquals(empresa, ExpEncontrada.getEmpresa());
		assertEquals(cargo, ExpEncontrada.getCargo());
		assertEquals(LocalDateTime.now(), ExpEncontrada.getDataInicio());
		assertEquals(LocalDateTime.now(), ExpEncontrada.getDataTermino());
	}

}
