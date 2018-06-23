package br.com.BudegaDoLuiz.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BudegaDoLuiz.beans.Cliente;

public class ClienteDAO {
	private Connection conn = ConexaoDB.getConnection();
	
//------------ metodo de inserção de cadastros clientes budega do luiz -----------//	
	public void cadastrar(Cliente cliente) {
		String sql = "INSERT INTO CLIENTES (nome,cpf,telefone) VALUES(?,?,?)";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getTelefone());
				
			preparador.execute();
			preparador.close();
				
			System.out.println("Cliente Cadastrado com sucesso");
			} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Cliente "+e.getMessage());
			}
	}


//------------ metodo de alteração de cadastros clientes budega do luiz -----------//	
	public void alterar(Cliente cliente) {
		String sql = "UPDATE CLIENTES SET nome = ?, cpf = ?, telefone = ? where idclientes = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getTelefone());
			preparador.setInt(4, cliente.getIdclientes());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cliente Alterado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao Alterar Cliente"+e.getMessage());
		}
	}
	
	
//------------ metodo de exclusão de cadastros clientes budega do luiz -----------//	
	public void deletar(Cliente cliente) {
		String sql = "DELETE FROM CLIENTES where idclientes = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, cliente.getIdclientes());
				
			preparador.execute();
			preparador.close();
			
			System.out.println("Cliente Deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao Deletar Cliente"+e.getMessage());
		}
	}	


//------------ metodo de lsitagem de cadastros clientes budega do luiz -----------//	
	public List<Cliente> buscarClientes(Cliente cliente) {
		String sql = "SELECT * FROM CLIENTES";
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()) {
				Cliente client = new Cliente();
				client.setIdclientes(resultados.getInt("idclientes"));
				client.setNome(resultados.getString("nome"));
				client.setCpf(resultados.getString("cpf"));
				client.setTelefone(resultados.getString("telefone"));
				lista.add(client);
			}
			
		}catch (SQLException e) {
				System.out.println("Erro ao Listar Clientes"+e.getMessage());
			}return lista;	
	}

//------------ metodo de buscar id de cadastros clientes budega do luiz -----------//
	public Cliente buscarporID(Integer idclientes) {
		Cliente clientRetorno = null;
		String sql = "SELECT * FROM CLIENTES where idclientes = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1,idclientes);
				
			ResultSet resultado = preparador.executeQuery();
				
			if(resultado.next()) {
				clientRetorno = new Cliente();
				clientRetorno.setIdclientes(resultado.getInt("idclientes"));
				clientRetorno.setNome(resultado.getString("nome"));
				clientRetorno.setCpf(resultado.getString("cpf"));
				clientRetorno.setTelefone(resultado.getString("telefone"));
			}
			System.out.println("Registro encontrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro Registro não encontrado "+e.getMessage());
		}
		return clientRetorno;
	}

}