package br.com.BudegaDoLuiz.testes;

import java.util.List;

import br.com.BudegaDoLuiz.beans.Produto;
import br.com.BudegaDoLuiz.conexao.ProdutoDAO;

public class TesteProdutoDAO {

	public static void main(String[] args) {
		//testCadastrar();
		//testAlterar();
		//testDeletar();
		testListar();

	}
	
//------------ teste de inserção de cadastros produtos budega do luiz -----------//
	public static void testCadastrar() {
		Produto prod = new Produto();
			prod.setCodigo("0072");
			prod.setNome("Braço de Buck");
			prod.setValor("108000");
			
			ProdutoDAO prodDAO = new ProdutoDAO();
			prodDAO.cadastrar(prod);	
	}

//------------ teste de alteração de cadastros produtos budega do luiz -----------//
	public static void testAlterar() {
		Produto prod = new Produto();
			prod.setCodigo("0001");
			prod.setNome("Canhão de plasma");
			prod.setValor("12000");
			prod.setIdprodutos(2);
			
			ProdutoDAO prodDAO = new ProdutoDAO();
			prodDAO.alterar(prod);
	}

//------------ teste de exclusão de cadastros produtos budega do luiz -----------//
	public static void testDeletar() {
		Produto prod = new Produto();
			prod.setIdprodutos(3);
			
			ProdutoDAO prodDAO = new ProdutoDAO();
			prodDAO.deletar(prod);
	}

//------------ teste de listagem de cadastros produtos budega do luiz -----------//
	public static void testListar() {
		Produto prod = new Produto();
		ProdutoDAO prodDAO = new ProdutoDAO();
		List<Produto> ListaResultado = prodDAO.buscarProdutos(prod);
		
		for(Produto p:ListaResultado) {
			System.out.println("Id "+p.getIdprodutos()+" Codigo: "+p.getCodigo()+" Nome: "+p.getNome()+" Valor: "+p.getValor());
		}
		
		
	}
}
