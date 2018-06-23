package br.com.BudegaDoLuiz.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.BudegaDoLuiz.beans.Usuario;
import br.com.BudegaDoLuiz.conexao.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
	}
		response.sendRedirect("erroLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		
		Usuario usu = new Usuario();
		usu.setEmail(semail);
		usu.setSenha(ssenha);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario userAutenticado = usuDAO.autenticacao(usu);
		
		if(userAutenticado != null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("userAutenticado", userAutenticado);
			sessao.setMaxInactiveInterval(3000);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			response.sendRedirect("erroLogin.jsp");
		}
		
		
	}

}
