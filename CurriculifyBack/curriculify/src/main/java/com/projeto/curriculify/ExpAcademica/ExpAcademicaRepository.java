package com.projeto.curriculify.ExpAcademica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpAcademicaRepository extends JpaRepository<ExpAcademica, Integer> {
	List<ExpAcademica> findAll();
	List<ExpAcademica> findAllByIdUsuario(Integer idUsuario);
}
