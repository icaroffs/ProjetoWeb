package br.com.BudegaDoLuiz.beans;

public class Cliente {
	private int idclientes;
	private String nome;
	private String cpf;
	private String telefone;
	
//------------ metodos de Getters e Setters de clientes budega do luiz -----------//	
	public int getIdclientes() {
		return idclientes;
	}
	public void setIdclientes(int idclientes) {
		this.idclientes = idclientes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}

