package com.projeto.curriculify.usuario;

public class UsuarioLoginRequestObject {
	private String email;
	private String senha;
	
	UsuarioLoginRequestObject(){}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
