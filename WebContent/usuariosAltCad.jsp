<%@ page import="br.com.BudegaDoLuiz.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cadastro de Usuarios</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		Usuario user = (Usuario)request.getAttribute("usuario");
	%>
		<form action="UsuariosControl" method="post">
			<input type="hidden" name="acao" value="salvar">
			<input type="hidden" name="idusuarios" value="<%=user.getIdusuarios()%>">
			<label>Nome:</label>
			<input type="text" name="nome" value="<%=user.getNome()%>">
			<label>E-mail:</label>
			<input type="text" name="email" value="<%=user.getEmail()%>">
			<label>Senha:</label>
			<input type="password" name="senha" value="<%=user.getSenha()%>">
			
			<input type="submit" value="Salvar">
		</form>

</body>
</html>