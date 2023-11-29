package com.projeto.curriculify.musica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository <Musica, Integer> { // Interface é igual uma classe, porém só utiliza-se os métodos contidos nela
	
	
}
