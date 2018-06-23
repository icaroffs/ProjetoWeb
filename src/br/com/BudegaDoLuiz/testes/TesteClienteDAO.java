package br.com.BudegaDoLuiz.testes;

import java.util.List;

import br.com.BudegaDoLuiz.beans.Cliente;
import br.com.BudegaDoLuiz.conexao.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {
			//testCadastrar();
			//testAlterar();
			//testDeletar();
			testListar();

		}
		
	//------------ teste de inserção de cadastros clientes budega do luiz -----------//
		public static void testCadastrar() {
			Cliente client = new Cliente();
				client.setNome("Icaro2");
				client.setCpf("06262141488");
				client.setTelefone("81987030114");
				
				ClienteDAO clientDAO = new ClienteDAO();
				clientDAO.cadastrar(client);	
		}

	//------------ teste de alteração de cadastros clientes budega do luiz -----------//
		public static void testAlterar() {
			Cliente client = new Cliente();
				client.setNome("Mopinha");
				client.setCpf("06262141400");
				client.setTelefone("81987719937");
				client.setIdclientes(1);
				
				ClienteDAO clientDAO = new ClienteDAO();
				clientDAO.alterar(client);
		}

	//------------ teste de exclusão de cadastros clientes budega do luiz -----------//
		public static void testDeletar() {
			Cliente client = new Cliente();
				client.setIdclientes(1);
				
				ClienteDAO clientDAO = new ClienteDAO();
				clientDAO.deletar(client);
		}

	//------------ teste de listagem de cadastros clientes budega do luiz -----------//
		public static void testListar() {
			Cliente client = new Cliente();
			ClienteDAO clientDAO = new ClienteDAO();
			List<Cliente> ListaResultado = clientDAO.buscarClientes(client);
			
			for(Cliente c:ListaResultado) {
				System.out.println("Id "+c.getIdclientes()+" Nome: "+c.getNome()+" Cpf: "+c.getCpf()+" Telefone: "+c.getTelefone());
			}
			
			
		}

}
