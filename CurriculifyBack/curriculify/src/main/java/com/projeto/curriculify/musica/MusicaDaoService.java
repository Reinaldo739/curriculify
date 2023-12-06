package com.projeto.curriculify.musica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MusicaDaoService {
	private static List<Musica> musicas = new ArrayList<>();
	
	private int musicasCount = 3;
	
	
	static {
		musicas.add(new Musica(1, "Flores", "Titâs"));
		musicas.add(new Musica(2, "All my life", "Foo Fighters"));
		musicas.add(new Musica(3, "The unforgiven", "Metallica"));
	}
	
	public List<Musica> findAll() {
		return musicas;
	}
	
	public Musica save(Musica musica) {
		if (musica.getId() == null) {
			musica.setId(++musicasCount);
		}
		
		musicas.add(musica);
		return musica;
	}
	
	public Musica findOne(Integer id) {
		for (Musica musica:musicas) {
			if (musica.getId() == id) {
				return musica;
			}
		}
		
		return null;
	}
	
	

}
	