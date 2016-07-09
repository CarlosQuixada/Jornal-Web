<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apagar Notícia</title>
</head>
<body>
	<h1>Apagar Notícia</h1>
	<table border=1>
		<tr>
			<td>Notícia</td>
			<td>Seção</td>
			<td>Autor da Notícia<td>
		</tr>
		
		<c:forEach var="noticia" items="${noticias}">
			<tr>
				<td>${noticia.titulo_noticia}</td>
				<td>${noticia.secao.titulo_secao}</td>
				<td>${noticia.jornalista.nome_usuario}</td>
				<td><a href="apagarNoticiaEditor?id_noticia=${noticia.id_noticia}">APAGAR NOTICIA</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>