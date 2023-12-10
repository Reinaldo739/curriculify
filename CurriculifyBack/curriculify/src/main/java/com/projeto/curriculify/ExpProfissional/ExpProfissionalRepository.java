package com.projeto.curriculify.ExpProfissional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpProfissionalRepository extends JpaRepository<ExpProfissional, Integer> {
	List<ExpProfissional> findAll();
	List<ExpProfissional> findAllByIdUsuario(Integer idUsuario);
}
