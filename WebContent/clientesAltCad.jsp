<%@ page import="br.com.BudegaDoLuiz.beans.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cadastro de Clientes</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		Cliente client = (Cliente)request.getAttribute("cliente");
	%>
		<form action="ClientesControl" method="post">
			<input type="hidden" name="acao" value="salvar">
			<input type="hidden" name="idclientes" value="<%=client.getIdclientes()%>">
			<label>Nome:</label>
			<input type="text" name="nome" value="<%=client.getNome()%>">
			<label>CPF:</label>
			<input type="text" name="cpf" value="<%=client.getCpf()%>">
			<label>Telefone:</label>
			<input type="text" name="telefone" value="<%=client.getTelefone()%>">
			
			<input type="submit" value="Salvar">
		</form>

</body>
</html>