package com.projeto.curriculify.usuario;

public class UsuarioCadastrarResponseObject {
	private boolean sucesso;
	private int idUsuario;
	private String msg;
	
	public UsuarioCadastrarResponseObject(boolean sucesso, int idUsuario, String msg) {
		super();
		this.sucesso = sucesso;
		this.idUsuario = idUsuario;
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
