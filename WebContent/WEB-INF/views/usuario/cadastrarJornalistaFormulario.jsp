<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Jornalista</title>
</head>
<body>
	<h2>Cadastrar Jornalista</h2>
	<form action="cadastrarJornalista" method="post">
		<input type="hidden" name="id_usuario" value="${usuario.id_usuario}"/>
		Nome:<input type="text" name="nome_usuario" value="${usuario.nome_usuario}"/><br/>
		Email:<input type="text" name="email" value="${usuario.email}"/><br/>
		Login:<input type="text" name="login" value="${usuario.login}"/><br/>
		Senha:<input type="password" name="senha" value="${usuario.senha}"/><br/>
		<input type="submit" value="Cadastrar"/>
	</form>
</body>
</html>