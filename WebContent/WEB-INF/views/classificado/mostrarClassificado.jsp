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
	<h1>Classificados</h1>
	<c:forEach var="classificado" items="${classificados}">
		<hr  width="60%" align="left"/><br/>
		<h2>${classificado.titulo_classificado}</h2>
		<p>Descrição:</p>
		<p>${classificado.texto_classificado}</p><br/>
		
		<p>Preço: ${classificado.preco}</p>
		<p>Telefone: ${classificado.telefone}</p>
		<b><p>Melhor Oferta: ${classificado.melhor_preco}</p></b>
		<b><p>Autor da Oferta: ${classificado.usuario_oferta.nome_usuario}</p></b><br/>
		
		
		<h4>Inserir Oferta</h4>
		<form action="realizarOferta" method="post">
		<input type="hidden" name="id_usuario_oferta" value="${usuario_logado.id_usuario}" />
		<input type="hidden" name="id_classificado" value="${classificado.id_classificado}"/>
		<input type="text" name="valor" />
		<input type="submit" value="Realizar Oferta">
		</form>
		<hr  width="60%" align="left"/><br/>
	</c:forEach>
	<a href="home">Voltar</a>
</body>
</html>