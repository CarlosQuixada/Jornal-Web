<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal UFC</title>
</head>
<body>
	<h2>Pagina Principal</h2>
	<b>Bem-Vindo ${usuario_logado.nome_usuario}</b>
	<a href="loginFormulario">Logar</a>
	<a href="inserirUsuarioFormulario">Cadastrar-se</a>
	<a href="logout">Logout</a><br/><br/>
	<a href="mostrarUsuarios">Cadastrar Jornalista</a>
	<a href="cadastrarSecaoFormulario">Cadastrar Seção</a>
	<a href="cadastrarClassificadoFormulario">Cadastrar Classificado</a>
	<a href="mostrarClassificado">Classificado</a>
	<a href="mostrarSecao">Cadastrar Noticia</a>
	<a href="listarNoticiaEditor">Apagar Noticia Editor</a><br/>
	<a href="listarNoticiaJornalista?id_usuario=${usuario_logado.id_usuario}">Apagar Noticia Jornalista</a>
	
	<c:forEach var="noticia" items="${noticias}">
		<a href="mostrarNoticia?id_noticia=${noticia.id_noticia}"><h2>${noticia.titulo_noticia}</h2></a>
		${noticia.subtitulo_noticia}
		<hr  width="60%" align="left"/>
	</c:forEach>
</body>
</html>