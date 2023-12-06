package com.projeto.curriculify;

import org.junit.jupiter.api.Test;

import com.projeto.curriculify.musica.Musica;

import junit.framework.TestCase;

public class TesteMusica extends TestCase {
	
	@Test
	public void testeMusica() {
		Integer identifier = 5;
		String nome = "Hey Jude";
		String banda = "Beatles";
		Musica musicaEncontrada = new Musica();
		musicaEncontrada.setId(5);
		musicaEncontrada.setNome("Hey Jude");
		musicaEncontrada.setBanda("Beatles");
		assertEquals(identifier, musicaEncontrada.getId());
		assertEquals(nome, musicaEncontrada.getNome());
		assertEquals(banda, musicaEncontrada.getBanda());
	}

}
