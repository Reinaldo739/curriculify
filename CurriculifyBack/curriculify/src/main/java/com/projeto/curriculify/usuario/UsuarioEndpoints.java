package com.projeto.curriculify.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@PostMapping("/jpa/logar")
	@ResponseBody
	public UsuarioResponseObject LogarUsuario(@RequestBody UsuarioLoginObject loginObject) {
		Usuario usuarioChecar = usuarioRepository.findByEmail(loginObject.getEmail());
		if(usuarioChecar != null) {
			if(usuarioChecar.getSenha().equals(loginObject.getSenha())) {
				return new UsuarioResponseObject(true, usuarioChecar.getId(), usuarioChecar.getEmail(), usuarioChecar.getNome());
			}
		} 
		
		return new UsuarioResponseObject(false, 0, "", "");
	}
	
	
	/*
	@PostMapping ("/jpa/CadastrarUsuario")
	public ResponseEntity <Object> CadastrarUsuario (@RequestBody Usuario usuario) {
		UsuarioRepository usuarioSalvo = usuarioRepository.save(usuario);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand (usuarioSalvo.getId()).toUri();
		return ResponseEntity.created(location).build();
	}*/
}
