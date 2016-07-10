<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Usuario</title>
</head>
<body>
	<h2>Cadastrar Usuário</h2><br/>
	<form action="inserirUsuario" method="post" enctype="multipart/form-data">
		Nome:<input type="text" name="nome_usuario"/><br/>
		Email:<input type="text" name="email"/><br/>
		Login:<input type="text" name="login"/><br/>
		Senha:<input type="password" name="senha"/><br/>
		Imagem:<input type="file" name="image"/><br/>
		<input type="submit" value="ENVIAR"/>
	</form>
</body>
</html>