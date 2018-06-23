<%@ page import="br.com.BudegaDoLuiz.beans.Usuario"%>
<%@ page import="br.com.BudegaDoLuiz.conexao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salvar cadastro de Usuarios</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		String snome = request.getParameter("nome");
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setNome(snome);
		user.setEmail(semail);
		user.setSenha(ssenha);
		
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.cadastrar(user);	
	%>
	<h1>Salvo com sucesso</h1>
	
	<%
	response.sendRedirect("UsuariosControl?acao=lis");
	%>

</body>
</html>