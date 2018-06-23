<%@ page import="java.util.List"%>
<%@ page import="br.com.BudegaDoLuiz.beans.Produto"%>
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
		List<Produto> lista = (List<Produto>)request.getAttribute("lista");
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Valor</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
		
	<%
	for(Produto p:lista) {
	%>
		<tr>
			<th><%=p.getIdprodutos() %></th>
			<th><%=p.getCodigo() %></th>
			<th><%=p.getNome() %></th>
			<th><%=p.getValor() %></th>
			<th><a href="ProdutosControl?acao=alt&idprodutos=<%=p.getIdprodutos() %>">Alterar</a></th>
			<th><a href="ProdutosControl?acao=ex&idprodutos=<%=p.getIdprodutos() %>">Excluir</a></th>
			
		</tr>
		
	<%
	}
	%>
	</table>
	 <a href="ProdutosControl?acao=cad">Cadastrar</a>
</body>
</html>