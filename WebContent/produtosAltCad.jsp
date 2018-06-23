<%@ page import="br.com.BudegaDoLuiz.beans.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cadastro de Produtos</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		Produto prod = (Produto)request.getAttribute("produto");
	%>
		<form action="ProdutosControl" method="post">
			<input type="hidden" name="acao" value="salvar">
			<input type="hidden" name="idprodutos" value="<%=prod.getIdprodutos()%>">
			<label>Codigo:</label>
			<input type="text" name="codigo" value="<%=prod.getCodigo()%>">
			<label>Nome:</label>
			<input type="text" name="nome" value="<%=prod.getNome()%>">
			<label>Valor:</label>
			<input type="text" name="valor" value="<%=prod.getValor()%>">
			
			<input type="submit" value="Salvar">
		</form>

</body>
</html>