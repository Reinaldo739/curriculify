package com.projeto.curriculify.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioEndpoints {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/logar")
	public @ResponseBody UsuarioLoginResponseObject LogarUsuario(@RequestBody UsuarioLoginRequestObject loginObject) {
		System.out.println(loginObject.getEmail());
		System.out.println(loginObject.getSenha());
		
		
		Usuario usuarioChecar = usuarioRepository.findByEmail(loginObject.getEmail());
		if(usuarioChecar != null) {
			if(usuarioChecar.getSenha().equals(loginObject.getSenha())) {
				return new UsuarioLoginResponseObject(true, usuarioChecar.getId(), "SUCESSO");
			}
		} 

		return new UsuarioLoginResponseObject(false, 0, "CREDENCIAL_INVALIDA");
	}
	
	
	@PostMapping ("/jpa/cadastrarUsuario")
	public UsuarioCadastrarResponseObject CadastrarUsuario (@RequestBody UsuarioCadastrarRequestObject usuario) {
		String emailDaNovaConta = usuario.getEmail();
		
		Usuario usuarioExistente = usuarioRepository.findByEmail(emailDaNovaConta);
		if(usuarioExistente != null) {
			return new UsuarioCadastrarResponseObject(false, 0, "USUARIO_JA_EXISTE");
		}
			
		Usuario salvarUsuario = new Usuario(usuario.getSenha(), usuario.getEmail(), usuario.getNome());
		Usuario usuarioSalvo = usuarioRepository.save(salvarUsuario);
		
		return new UsuarioCadastrarResponseObject(true, usuarioSalvo.getId(), "SUCESSO");
	}
	
	@GetMapping ("/dadosUsuario")
	public UsuarioGetDadosUsuarioResponseObject GetUsuario (@RequestParam(name = "idUsuario", required = true) int idUsuario) {		
		Usuario usuarioDentroDoBanco = usuarioRepository.findById(idUsuario);
		if(usuarioDentroDoBanco == null) {
			return new UsuarioGetDadosUsuarioResponseObject(0, "", "", false, "USUARIO_INEXISTENTE");
		} else {
			return new UsuarioGetDadosUsuarioResponseObject(usuarioDentroDoBanco.getId(), usuarioDentroDoBanco.getNome(), usuarioDentroDoBanco.getEmail(), true, "SUCESSO");
		}
		
	}
}
