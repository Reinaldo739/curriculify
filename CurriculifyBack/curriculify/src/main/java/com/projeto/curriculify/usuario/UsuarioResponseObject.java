package com.projeto.curriculify.usuario;

public class UsuarioResponseObject {
	public int idUsuario;
	public boolean sucesso;
	public String email;
	public String nome;
	
	UsuarioResponseObject(boolean sucesso, int idUsuario, String email, String nome) {
		this.sucesso = sucesso;
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}
}
