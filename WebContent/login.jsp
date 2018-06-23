<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<div class="arealogin">
			<div class="imglogin">
				<a href="home"><img src="img/budegalogo.png"></a>
			</div>
				<form action="Autenticador" method="post">
					<input type="text" name="email" placeholder="E-mail">
					<input type="password" name="senha">
					<input type="submit" name="enviar" value="Login">
				</form>
				<div id="recuperarcad">
					<a href="#">Esqueci meu login ou senha</a>
				</div>
			</div>
	
</body>
</html>