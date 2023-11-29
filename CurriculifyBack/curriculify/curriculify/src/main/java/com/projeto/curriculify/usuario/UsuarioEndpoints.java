package com.projeto.curriculify.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.curriculify.musica.Musica;

import java.net.URI;
import java.util.List;

@RestController
public class UsuarioEndpoints {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping ("/jpa/usuarios")
	public String PegarUsuarios() {
		
		return "Hello World!";
	}
}
