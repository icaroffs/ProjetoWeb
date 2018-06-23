package br.com.BudegaDoLuiz.Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BudegaDoLuiz.beans.Cliente;
import br.com.BudegaDoLuiz.conexao.ClienteDAO;

/**
 * Servlet implementation class ClientesControl
 */
@WebServlet("/ClientesControl")
public class ClientesControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente client = new Cliente();
		String acao = request.getParameter("acao");
		ClienteDAO clientDAO = new ClienteDAO();
		
		if(acao !=null && acao.equals("lis")) {
			List<Cliente>lista = clientDAO.buscarClientes(client);
	
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("clientes.jsp");
		saida.forward(request, response);
		
		}else if(acao !=null && acao.equals("ex")) {
			String idclientes = request.getParameter("idclientes");
			client.setIdclientes(Integer.parseInt(idclientes));
			clientDAO.deletar(client);
			
			response.sendRedirect("ClientesControl?acao=lis");
			
		}else if(acao !=null && acao.equals("alt")) {
			String idclientes = request.getParameter("idclientes");
			Cliente cliente = clientDAO.buscarporID(Integer.parseInt(idclientes));
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("clientesAltCad.jsp").forward(request, response);
			
		}else if(acao !=null && acao.equals("cad")) {
			RequestDispatcher saida = request.getRequestDispatcher("clientesCad.jsp");
			saida.forward(request, response);
		}	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sidclientes = request.getParameter("idclientes");
		String snome = request.getParameter("nome");
		String scpf = request.getParameter("cpf");
		String stelefone = request.getParameter("telefone");
		
		
		Cliente cliente = new Cliente();
		cliente.setNome(snome);
		cliente.setCpf(scpf);
		cliente.setTelefone(stelefone);;
		cliente.setIdclientes(Integer.parseInt(sidclientes));
		
		ClienteDAO clientDAO = new ClienteDAO();
		clientDAO.alterar(cliente);
		PrintWriter out = response.getWriter();
		out.println("Alterado com sucesso");
		response.sendRedirect("ClientesControl?acao=lis");
	}

}
