<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classificados</title>
</head>
<body>
	<h2>Classificados</h2>
	<c:forEach var="classificado" items="${classificados}">
		<hr  width="60%" align="left"/><br/>
		<h4>${classificado.titulo_classificado}</h4>
		<p>Preço: ${classificado.preco}</p>
		<p>Telefone: ${classificado.telefone}</p>
		<p>Descrição:</p>
		<p>${classificado.texto_classificado}</p><br/>
	</c:forEach>
</body>
</html>