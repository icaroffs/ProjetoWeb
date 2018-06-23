package br.com.BudegaDoLuiz.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BudegaDoLuiz.beans.Usuario;

public class UsuarioDAO {
	private Connection conn = ConexaoDB.getConnection();
	
//------------ metodo de inserção de cadastros usuarios budega do luiz -----------//	
	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO USUARIOS (nome,email,senha) VALUES(?,?,?)";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
				
			preparador.execute();
			preparador.close();
				
			System.out.println("Usuario Cadastrado com sucesso");
			} catch (SQLException e) {
			System.out.println("Erro ao Cadastrar Usuario "+e.getMessage());
			}
	}

	
//------------ metodo de alteração de cadastros usuarios budega do luiz -----------//	
	public void alterar(Usuario usuario) {
		String sql = "UPDATE USUARIOS SET nome = ?, email = ?, senha = ? where idusuarios = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getEmail());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getIdusuarios());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario Alterado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao Alterar Usuarios"+e.getMessage());
		}
	}
	

//------------ metodo de exclusão de cadastros usuarios budega do luiz -----------//	
	public void deletar(Usuario usuario) {
		String sql = "DELETE FROM USUARIOS where idusuarios = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1, usuario.getIdusuarios());
				
			preparador.execute();
			preparador.close();
			
			System.out.println("Usuario Deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao Deletar Usuario"+e.getMessage());
		}
	}	


//------------ metodo de lsitagem de cadastros usuarios budega do luiz -----------//	
	public List<Usuario> buscarUsuarios(Usuario usuario) {
		String sql = "SELECT * FROM USUARIOS";
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()) {
				Usuario user = new Usuario();
				user.setIdusuarios(resultados.getInt("idusuarios"));
				user.setNome(resultados.getString("nome"));
				user.setEmail(resultados.getString("email"));
				user.setSenha(resultados.getString("senha"));
				lista.add(user);
			}
			
		}catch (SQLException e) {
				System.out.println("Erro ao Listar Usuarios"+e.getMessage());
			}return lista;	
	}
	
//------------ metodo de buscar id de cadastros usuarios budega do luiz -----------//
	public Usuario buscarporID(Integer idusuarios) {
		Usuario userRetorno = null;
		String sql = "SELECT * FROM USUARIOS where idusuarios = ?";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setInt(1,idusuarios);
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				userRetorno = new Usuario();
				userRetorno.setIdusuarios(resultado.getInt("idusuarios"));
				userRetorno.setNome(resultado.getString("nome"));
				userRetorno.setEmail(resultado.getString("email"));
				userRetorno.setSenha(resultado.getString("senha"));
			}
			System.out.println("Registro encontrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro Registro não encontrado "+e.getMessage());
		}
		return userRetorno;
	}

//------------ metodo de autenticação de usuarios budega do luiz -----------//	
	public Usuario autenticacao(Usuario usuario) {
		Usuario userRetorno = null;
		String sql = "SELECT * FROM USUARIOS where email = ? and senha = ? ";
		try {
			PreparedStatement preparador = conn.prepareStatement(sql);
			preparador.setString(1,usuario.getEmail());
			preparador.setString(2,usuario.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				userRetorno = new Usuario();
				userRetorno.setIdusuarios(resultado.getInt("idusuarios"));
				userRetorno.setNome(resultado.getString("nome"));
				userRetorno.setEmail(resultado.getString("email"));
				userRetorno.setSenha(resultado.getString("senha"));
			}
			System.out.println("Registro encontrado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro Registro não encontrado "+e.getMessage());
		}
		return userRetorno;
	}
}