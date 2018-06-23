<%@ page import="java.util.List"%>
<%@ page import="br.com.BudegaDoLuiz.beans.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		
	<%
		List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Telefone</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
		
	<%
	for(Cliente c:lista) {
	%>
		<tr>
			<th><%=c.getIdclientes() %></th>
			<th><%=c.getNome() %></th>
			<th><%=c.getCpf() %></th>
			<th><%=c.getTelefone() %></th>
			<th><a href="ClientesControl?acao=alt&idclientes=<%=c.getIdclientes() %>">Alterar</a></th>
			<th><a href="ClientesControl?acao=ex&idclientes=<%=c.getIdclientes() %>">Excluir</a></th>
			
		</tr>
		
	<%
	}
	%>
	</table>
	 <a href="ClientesControl?acao=cad">Cadastrar</a>
</body>
</html>