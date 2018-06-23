<%@ page import="br.com.BudegaDoLuiz.beans.Cliente"%>
<%@ page import="br.com.BudegaDoLuiz.conexao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salvar Cadastro Clientes</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		String snome = request.getParameter("nome");
		String scpf = request.getParameter("cpf");
		String stelefone = request.getParameter("telefone");
		
		Cliente client = new Cliente();
		client.setNome(snome);
		client.setCpf(scpf);
		client.setTelefone(stelefone);
		
		ClienteDAO clientDAO = new ClienteDAO();
		clientDAO.cadastrar(client);	
	%>
	<h1>Salvo com sucesso</h1>
	
	<%
	response.sendRedirect("ClientesControl?acao=lis");
	%>
</body>
</html>