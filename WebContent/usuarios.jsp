<%@ page import="java.util.List"%>
<%@ page import="br.com.BudegaDoLuiz.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
		
	<%
	for(Usuario u:lista) {
	%>
		<tr>
			<th><%=u.getIdusuarios() %></th>
			<th><%=u.getNome() %></th>
			<th><%=u.getEmail() %></th>
			<th><a href="UsuariosControl?acao=alt&idusuarios=<%=u.getIdusuarios() %>">Alterar</a></th>
			<th><a href="UsuariosControl?acao=ex&idusuarios=<%=u.getIdusuarios() %>">Excluir</a></th>
			
		</tr>
		
	<%
	}
	%>
	</table>
	 <a href="UsuariosControl?acao=cad">Cadastrar</a>
</body>
</html>