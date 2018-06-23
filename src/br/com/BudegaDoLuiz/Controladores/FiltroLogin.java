package br.com.BudegaDoLuiz.Controladores;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/*")
public class FiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//HttpSession sessao = request.getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest .getRequestURI();
		
		HttpSession sessao = httpServletRequest .getSession();
		
		if (sessao.getAttribute("userAutenticado")!=null || url.lastIndexOf("login.jsp")>-1 ||
		url.lastIndexOf("Autenticador") >-1 ){
		chain.doFilter(request, response); 
		}else{
		((HttpServletResponse) response).sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
