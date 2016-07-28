<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerenciar Funções</title>
</head>
<body>
	<h1>Funções</h1>
	<a href="mostrarUsuarios">Cadastrar Jornalista</a><br/>
	<a href="cadastrarSecaoFormulario">Cadastrar Seção</a><br/>
	<a href="cadastrarClassificadoFormulario">Cadastrar Classificado</a><br/>
	<a href="mostrarSecao">Cadastrar Noticia</a><br/>
	<a href="listarNoticiaEditor">Apagar Noticia Editor</a><br/>
	<a href="listarNoticiaJornalista?id_usuario=${usuario_logado.id_usuario}">Apagar Noticia Jornalista</a><br/><br/>
	<a href="home">Voltar</a>
</body>
</html>