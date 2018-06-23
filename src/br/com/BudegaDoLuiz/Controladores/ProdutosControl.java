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

import br.com.BudegaDoLuiz.beans.Produto;
import br.com.BudegaDoLuiz.conexao.ProdutoDAO;

/**
 * Servlet implementation class ProdutosControl
 */
@WebServlet("/ProdutosControl")
public class ProdutosControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutosControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produto prod = new Produto();
		String acao = request.getParameter("acao");
		ProdutoDAO prodDAO = new ProdutoDAO();
		
		if(acao !=null && acao.equals("lis")) {
			List<Produto>lista = prodDAO.buscarProdutos(prod);
	
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("produtos.jsp");
		saida.forward(request, response);
		
		}else if(acao !=null && acao.equals("ex")) {
			String idprodutos = request.getParameter("idprodutos");
			prod.setIdprodutos(Integer.parseInt(idprodutos));
			prodDAO.deletar(prod);
			
			response.sendRedirect("ProdutosControl?acao=lis");
			
		}else if(acao !=null && acao.equals("alt")) {
			String idprodutos = request.getParameter("idprodutos");
			Produto produto = prodDAO.buscarporID(Integer.parseInt(idprodutos));
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("produtosAltCad.jsp").forward(request, response);
			
		}else if(acao !=null && acao.equals("cad")) {
			RequestDispatcher saida = request.getRequestDispatcher("produtosCad.jsp");
			saida.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidprodutos = request.getParameter("idprodutos");
		String scodigo = request.getParameter("codigo");
		String snome = request.getParameter("nome");
		String svalor = request.getParameter("valor");
		
		
		Produto produto = new Produto();
		produto.setCodigo(scodigo);
		produto.setNome(snome);
		produto.setValor(svalor);
		produto.setIdprodutos(Integer.parseInt(sidprodutos));
		
		ProdutoDAO prodDAO = new ProdutoDAO();
		prodDAO.alterar(produto);
		PrintWriter out = response.getWriter();
		out.println("Alterado com sucesso");
		response.sendRedirect("ProdutosControl?acao=lis");
	}

}