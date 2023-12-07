package com.projeto.curriculify.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	Usuario findByEmail(String email);
	Usuario findById(int id);
}


/*
	CLASSE EXEMPLO
	
	package com.projeto.curriculify.musica;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository <Musica, Integer> { // Interface é igual uma classe, porém só utiliza-se os métodos contidos nela
	
	
}

*/