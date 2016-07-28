<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Noticia</title>
</head>
<body>
	<h2>Cadastrar Noticia - ${usuario_logado.nome_usuario}</h2><br/>
	Escolha a Seção:<br/>
	<table border=1>
		<tr>
			<td>Seção</td>
		</tr>
		<c:forEach var="secao" items="${secoes}">
		<tr>
			<td>${secao.titulo_secao} - ${secao.id_secao}</td>
			<td><a href="cadastrarNoticiaFormulario?id_secao=${secao.id_secao}">Cadastrar Noticia</a>		
		</tr>
		</c:forEach>
	</table>
	<a href="gerenciarFuncao">Voltar</a>
</body>
</html>