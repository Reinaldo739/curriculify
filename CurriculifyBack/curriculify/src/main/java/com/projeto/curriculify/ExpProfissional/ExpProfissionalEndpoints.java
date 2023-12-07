package com.projeto.curriculify.ExpProfissional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curriculify.ExpAcademica.EnvioUsuario;

@RestController
public class ExpProfissionalEndpoints {

	@Autowired
    private ExpProfissionalRepository ExpProfissionalRepository;

    @GetMapping("/jpa/ExpProfissional")
    public List<ExpProfissional> listarExpProfissional(@RequestBody EnvioUsuario idUsuario) {
    	return ExpProfissionalRepository.findAllByIdUsuario(idUsuario.getIdUsuario());
    }
    
    @PostMapping("/jpa/ExpProfissional")
    public ExpProfissionalResponseObject adicionarExpProfissional(@RequestBody ExpProfissionalCriar expProfissional) {
  
    	ExpProfissional novaExpProfissional = new ExpProfissional(expProfissional.getIdUsuario(), expProfissional.getEmpresa(), expProfissional.getCargo(), expProfissional.getDataInicio(), expProfissional.getDataTermino());
    	ExpProfissional expProfissionalDentroDoBanco = ExpProfissionalRepository.save(novaExpProfissional);
        return new ExpProfissionalResponseObject(true, expProfissionalDentroDoBanco.getId());
    }
}

    

