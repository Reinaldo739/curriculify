package com.projeto.curriculify.usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String login;
	private String senha;
	
	public Usuario (Integer id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
}








/*

CLASSE EXEMPLO

package com.projeto.curriculify.musica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity //Informa que a classe Musica cria tabelas com os atributos dos objetos no banco de dados
public class Musica {
	
	@Id //Informa que o id é o ID da tabela
	@GeneratedValue
	private Integer id;
	private String nome;
	private String banda;
	
	public Musica (Integer id, String nome, String banda) {
		super();
		this.id = id;
		this.nome = nome;
		this.banda = banda;
		//
		//
	}
	
	public Musica() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	@Override
	public String toString() {
		return "Musica [id=" + id + ", nome=" + nome + ", banda=" + banda + "]";
	}
	
}
*/


