package br.com.BudegaDoLuiz.beans;

public class Usuario {
	private int idusuarios;
	private String nome;
	private String email;
	private String senha;
	
//------------ metodos de Getters e Setters de usuarios budega do luiz -----------//		
	public int getIdusuarios() {
		return idusuarios;
	}
	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
