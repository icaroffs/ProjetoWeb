package br.com.BudegaDoLuiz.testes;

import java.util.List;

import br.com.BudegaDoLuiz.beans.Usuario;
import br.com.BudegaDoLuiz.conexao.UsuarioDAO;

public class TesteUsuarioDAO {
	
	public static void main(String[] args) {
		//testCadastrar();
		//testAlterar();
		//testDeletar();
		//testListar();

	}
	
//------------ teste de inserção de cadastros usuarios budega do luiz -----------//
	public static void testCadastrar() {
		Usuario user = new Usuario();
			user.setNome("katia123");
			user.setEmail("katiaalbuquerque01@gmai1l.com");
			user.setSenha("666");
			
			UsuarioDAO userDAO = new UsuarioDAO();
			userDAO.cadastrar(user);	
	}

//------------ teste de alteração de cadastros usuarios budega do luiz -----------//
	public static void testAlterar() {
		Usuario user = new Usuario();
			user.setNome("katia Regina");
			user.setEmail("katiaalbuquerque@gmail.com");
			user.setSenha("666belzebu");
			user.setIdusuarios(4);
			
			UsuarioDAO userDAO = new UsuarioDAO();
			userDAO.alterar(user);
	}
	
//------------ teste de exclusão de cadastros usuarios budega do luiz -----------//
	public static void testDeletar() {
		Usuario user = new Usuario();
			user.setIdusuarios(4);
			
			UsuarioDAO userDAO = new UsuarioDAO();
			userDAO.deletar(user);
	}

//------------ teste de listagem de cadastros usuarios budega do luiz -----------//
	public static void testListar() {
		Usuario user = new Usuario();
		UsuarioDAO userDAO =new UsuarioDAO();
		List<Usuario> ListaResultado = userDAO.buscarUsuarios(user);
		
		for(Usuario u:ListaResultado) {
			System.out.println("Id "+u.getIdusuarios()+" Nome: "+u.getNome()+" E-mail: "+u.getEmail());
		}
		
		
	}
}
