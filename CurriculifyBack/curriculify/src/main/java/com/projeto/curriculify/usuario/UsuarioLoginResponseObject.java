package com.projeto.curriculify.usuario;

import org.springframework.web.bind.annotation.CrossOrigin;

public class UsuarioLoginResponseObject {
	public int idUsuario;
	public boolean sucesso;
	public String msg;
	
	UsuarioLoginResponseObject(boolean sucesso, int idUsuario, String msg) {
		this.sucesso = sucesso;
		this.idUsuario = idUsuario;
		this.msg = msg;
	}
}
