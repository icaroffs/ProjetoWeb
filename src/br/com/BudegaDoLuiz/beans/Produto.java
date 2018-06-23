package br.com.BudegaDoLuiz.beans;

public class Produto {
	private int idprodutos;
	private String codigo;
	private String nome;
	private String valor;
	
//------------ metodos de Getters e Setters de produtos budega do luiz -----------//	
	public int getIdprodutos() {
		return idprodutos;
	}
	public void setIdprodutos(int idprodutos) {
		this.idprodutos = idprodutos;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	

}
