package com.projeto.curriculify.usuario;

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
