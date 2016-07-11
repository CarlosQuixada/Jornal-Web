<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>LOGIN</h2>
	<form action="login" method="post">
		Login:<input type="text" placeholder="Login" name="login"/><br/>
		Senha:<input type="password" placeholder="*****" name="senha"/><br/>
		<!--Tipo de Conta:<br/>
		<input type="radio" name="status" value="1"/>Editor<br/>
		<input type="radio" name="status" value="2">Jornalista<br/>
		<input type="radio" name="status" value="3">Leitor<br/>-->
		<input type="submit" value="Logar"/>
	</form>
</body>
</html>