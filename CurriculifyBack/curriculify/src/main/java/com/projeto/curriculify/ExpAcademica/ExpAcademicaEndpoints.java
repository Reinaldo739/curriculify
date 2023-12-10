package com.projeto.curriculify.ExpAcademica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ExpAcademicaEndpoints {

    @Autowired
    private ExpAcademicaRepository ExpAcademicaRepository;

    @GetMapping("/jpa/ExpAcademica")
    public List<ExpAcademica> listarExpAcademicas(@RequestParam(name = "idUsuario", required = true) int idUsuario) {
    	return ExpAcademicaRepository.findAllByIdUsuario(idUsuario);
    }
    
    @PostMapping("/jpa/ExpAcademica")
    public ExpAcademicaResponseObject adicionarExpAcademica(@RequestBody ExpAcademicaCriar expAcademica) {
  
    	ExpAcademica novaExpAcademica = new ExpAcademica(expAcademica.getIdUsuario(), expAcademica.getInstituicaoEnsino(), expAcademica.getCurso(), expAcademica.getDataInicio(), expAcademica.getDataTermino());
    	ExpAcademica expAcademicaDentroDoBanco = ExpAcademicaRepository.save(novaExpAcademica);
        return new ExpAcademicaResponseObject(true, expAcademicaDentroDoBanco.getId());
    }
}

    