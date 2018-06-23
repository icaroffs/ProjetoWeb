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

import br.com.BudegaDoLuiz.beans.Usuario;
import br.com.BudegaDoLuiz.conexao.UsuarioDAO;
/**
 * Servlet implementation class UsuariosControl
 */
@WebServlet("/UsuariosControl")
public class UsuariosControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosControl() {
        super();
        // TODO Auto-generated constructor stub
    }
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario user = new Usuario();
		String acao = request.getParameter("acao");
		UsuarioDAO userDAO = new UsuarioDAO();
		
		if(acao !=null && acao.equals("lis")) {
			List<Usuario>lista = userDAO.buscarUsuarios(user);
	
		request.setAttribute("lista", lista);
		RequestDispatcher saida = request.getRequestDispatcher("usuarios.jsp");
		saida.forward(request, response);
		
		}else if(acao !=null && acao.equals("ex")) {
			String idusuarios = request.getParameter("idusuarios");
			user.setIdusuarios(Integer.parseInt(idusuarios));
			userDAO.deletar(user);
			
			response.sendRedirect("UsuariosControl?acao=lis");
			
		}else if(acao !=null && acao.equals("alt")) {
			String idusuarios = request.getParameter("idusuarios");
			Usuario usuario = userDAO.buscarporID(Integer.parseInt(idusuarios));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("usuariosAltCad.jsp").forward(request, response);
			
		}else if(acao !=null && acao.equals("cad")) {
			RequestDispatcher saida = request.getRequestDispatcher("usuariosCad.jsp");
			saida.forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sidusuarios = request.getParameter("idusuarios");
		String snome = request.getParameter("nome");
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		
		
		Usuario usuario = new Usuario();
		usuario.setNome(snome);
		usuario.setEmail(semail);
		usuario.setSenha(ssenha);
		usuario.setIdusuarios(Integer.parseInt(sidusuarios));
		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.alterar(usuario);
		PrintWriter out = response.getWriter();
		out.println("Alterado com sucesso");
		response.sendRedirect("UsuariosControl?acao=lis");
	}

}
