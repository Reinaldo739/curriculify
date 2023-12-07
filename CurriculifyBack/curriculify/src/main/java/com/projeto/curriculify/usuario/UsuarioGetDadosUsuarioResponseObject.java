package com.projeto.curriculify.usuario;

public class UsuarioGetDadosUsuarioResponseObject {
	private int idUsuario;
	private String nome;
	private String email;
	private boolean sucesso;
	private String msg;
	
	UsuarioGetDadosUsuarioResponseObject(int idUsuario, String nome, String email, boolean sucesso, String msg) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.sucesso = sucesso;
		this.msg = msg;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
