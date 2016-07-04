<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Classificado</title>
</head>
<body>
	<h1>Cadastrar Classificado</h1> 
	<form action="cadastrarClassificado" method="post">
		Titulo:<input type="text" name="titulo_classificado"/><br/>
		Preço:<input type="text" name="preco"/><br/>
		Telefone:<input type="text" name="telefone"/><br/>
		Descrição:<br/><textarea rows="4" cols="50" name="texto_classificado"></textarea><br/>
		<input type="submit" value="Cadastrar"/>
	</form>
</body>
</html>