package com.projeto.curriculify.ExpAcademica;

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
public class ExpAcademicaEndpoints {

    @Autowired
    private ExpAcademicaRepository ExpAcademicaRepository;

    @GetMapping("/jpa/ExpAcademica")
    public List<ExpAcademica> listarExpAcademicas() {
    	return ExpAcademicaRepository.findAll();
    }
    
    @PostMapping("/jpa/ExpAcademica")
    public ResponseEntity<Object> adicionarExpAcademica(@RequestBody ExpAcademica expAcademica) {
        // Aqui você chama o método do repositório para salvar a experiência acadêmica no banco de dados
        ExpAcademica novaExpAcademica = ExpAcademicaRepository.save(expAcademica);
        
        // Após salvar, você pode retornar um URI para a nova experiência acadêmica criada
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaExpAcademica.getCdExpAcademica()).toUri();
        
        return ResponseEntity.created(location).build();
    }
}

    