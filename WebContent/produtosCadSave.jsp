<%@ page import="br.com.BudegaDoLuiz.beans.Produto"%>
<%@ page import="br.com.BudegaDoLuiz.conexao.ProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salvar Cadastro de Produtos</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		String scodigo = request.getParameter("codigo");
		String snome = request.getParameter("nome");
		String svalor = request.getParameter("valor");
		
		Produto prod = new Produto();
		prod.setCodigo(scodigo);
		prod.setNome(snome);
		prod.setValor(svalor);
		
		ProdutoDAO prodDAO = new ProdutoDAO();
		prodDAO.cadastrar(prod);	
	%>
	<h1>Salvo com sucesso</h1>
	
	<%
	response.sendRedirect("ProdutosControl?acao=lis");
	%>

</body>
</html>