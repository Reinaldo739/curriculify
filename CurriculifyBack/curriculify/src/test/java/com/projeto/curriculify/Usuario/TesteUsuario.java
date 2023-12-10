package com.projeto.curriculify.Usuario;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.projeto.curriculify.usuario.Usuario;

import junit.framework.TestCase;

public class TesteUsuario extends TestCase {
	
	@Test
	public void testeExpAcademica() {
		Integer id = 1;
		String login = "Teste";
		String senha = "SenhaSegura123";
		String email = "teste@outlook.com";
		String nome = "Pedro Carlos Vinicius";
		
		Usuario UsuarioEncontrado = new Usuario();
		UsuarioEncontrado.setId(1);
		UsuarioEncontrado.setSenha("SenhaSegura123");
		UsuarioEncontrado.setEmail("teste@outlook.com");
		UsuarioEncontrado.setNome("Pedro Carlos Vinicius");
		assertEquals(1, UsuarioEncontrado.getId());
		assertEquals("SenhaSegura123", UsuarioEncontrado.getSenha());
		assertEquals("teste@outlook.com", UsuarioEncontrado.getEmail());
		assertEquals("Pedro Carlos Vinicius", UsuarioEncontrado.getNome());		
	}
}
