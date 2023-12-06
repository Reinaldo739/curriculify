package com.projeto.curriculify.musica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MusicaJPAResource {
	
	@Autowired
	private MusicaRepository musicaRepository;
	
		
	@GetMapping ("/jpa/musicas")
	public List<Musica> retrieveAllMusicas() {
		List<Musica> musicas = musicaRepository.findAll();
		
		return musicas;
	}
	
	@DeleteMapping ("/jpa/musicas/{id}")
	public void deleteUser (@PathVariable int id) {
		musicaRepository.deleteById(id);
	}
	
	@PostMapping ("/jpa/musicas")
	public ResponseEntity <Object> createUser (@RequestBody Musica musica) {
		Musica savedMusica = musicaRepository.save(musica);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand (savedMusica.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
} 
