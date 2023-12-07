package com.projeto.curriculify.usuario;

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
public class UsuarioEndpoints {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/jpa/logar")
	@ResponseBody
	public UsuarioLoginResponseObject LogarUsuario(@RequestBody UsuarioLoginRequestObject loginObject) {
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
	
	@GetMapping ("/jpa/dadosUsuario")
	public UsuarioGetDadosUsuarioResponseObject GetUsuario (@RequestBody UsuarioGetDadosUsuarioRequestBody usuario) {
		int idUsuario = usuario.getIdUsuario();
		
		Usuario usuarioDentroDoBanco = usuarioRepository.findById(idUsuario);
		if(usuarioDentroDoBanco == null) {
			return new UsuarioGetDadosUsuarioResponseObject(0, "", "", false, "USUARIO_INEXISTENTE");
		} else {
			return new UsuarioGetDadosUsuarioResponseObject(usuarioDentroDoBanco.getId(), usuarioDentroDoBanco.getNome(), usuarioDentroDoBanco.getEmail(), true, "SUCESSO");
		}
		
	}
}
