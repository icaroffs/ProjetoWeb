<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<title>header</title>
</head>
<body>
	<div class="navbar">
    <a href="index.jsp">Home</a>
      <div class="dropdown">
        <button class="dropbtn">Cadastros 
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
          <a href="ClientesControl?acao=lis">Clientes</a>
          <a href="ProdutosControl?acao=lis">Produtos</a>
          <a href="UsuariosControl?acao=lis">Usuários</a>
        </div>
        </div> 

        <div class="dropdown">
        <button class="dropbtn">Vendas 
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
          <a href="vendas.jsp">Pedidos de Venda</a>
        </div>
        </div>
    <a href="Autenticador">Sair</a>
</div> 
	

</body>
</html>