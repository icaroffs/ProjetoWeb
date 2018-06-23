package br.com.BudegaDoLuiz.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BudegaDoLuiz.beans.Produto;

public class ProdutoDAO {
private Connection conn = ConexaoDB.getConnection();
	
	//------------ metodo de inserção de cadastros produtos budega do luiz -----------//	
		public void cadastrar(Produto produto) {
			String sql = "INSERT INTO PRODUTOS (codigo,nome,valor) VALUES(?,?,?)";
			try {
				PreparedStatement preparador = conn.prepareStatement(sql);
				preparador.setString(1, produto.getCodigo());
				preparador.setString(2, produto.getNome());
				preparador.setString(3, produto.getValor());
					
				preparador.execute();
				preparador.close();
					
				System.out.println("Produto Cadastrado com sucesso");
				} catch (SQLException e) {
				System.out.println("Erro ao Cadastrar Produto "+e.getMessage());
				}
		}


	//------------ metodo de alteração de cadastros produtos budega do luiz -----------//	
		public void alterar(Produto produto) {
			String sql = "UPDATE PRODUTOS SET codigo = ?, nome = ?, valor = ? where idprodutos = ?";
			try {
				PreparedStatement preparador = conn.prepareStatement(sql);
				preparador.setString(1, produto.getCodigo());
				preparador.setString(2, produto.getNome());
				preparador.setString(3, produto.getValor());
				preparador.setInt(4, produto.getIdprodutos());
				
				preparador.execute();
				preparador.close();
				
				System.out.println("Produto Alterado com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao Alterar Produto"+e.getMessage());
			}
		}
		
		
	//------------ metodo de exclusão de cadastros produtos budega do luiz -----------//	
		public void deletar(Produto produto) {
			String sql = "DELETE FROM PRODUTOS where idprodutos = ?";
			try {
				PreparedStatement preparador = conn.prepareStatement(sql);
				preparador.setInt(1, produto.getIdprodutos());
					
				preparador.execute();
				preparador.close();
				
				System.out.println("Produto Deletado com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao Deletar Produto"+e.getMessage());
			}
		}	


	//------------ metodo de lsitagem de cadastros produtos budega do luiz -----------//	
		public List<Produto> buscarProdutos(Produto produto) {
			String sql = "SELECT * FROM PRODUTOS";
			List<Produto> lista = new ArrayList<Produto>();
			try {
				PreparedStatement preparador = conn.prepareStatement(sql);
				ResultSet resultados = preparador.executeQuery();
				while(resultados.next()) {
					Produto prod = new Produto();
					prod.setIdprodutos(resultados.getInt("idprodutos"));
					prod.setCodigo(resultados.getString("codigo"));
					prod.setNome(resultados.getString("nome"));
					prod.setValor(resultados.getString("valor"));
					
					lista.add(prod);
				}
				
			}catch (SQLException e) {
					System.out.println("Erro ao Listar Produtos"+e.getMessage());
				}return lista;	
		}	
	//------------ metodo de buscar id de cadastros produtos budega do luiz -----------//
		public Produto buscarporID(Integer idprodutos) {
			Produto prodRetorno = null;
			String sql = "SELECT * FROM PRODUTOS where idprodutos = ?";
			try {
				PreparedStatement preparador = conn.prepareStatement(sql);
				preparador.setInt(1,idprodutos);
				
				ResultSet resultado = preparador.executeQuery();
				
				if(resultado.next()) {
					prodRetorno = new Produto();
					prodRetorno.setIdprodutos(resultado.getInt("idprodutos"));
					prodRetorno.setCodigo(resultado.getString("codigo"));
					prodRetorno.setNome(resultado.getString("nome"));
					prodRetorno.setValor(resultado.getString("valor"));
				}
				System.out.println("Registro encontrado com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro Registro não encontrado "+e.getMessage());
			}
			return prodRetorno;
		}

}
