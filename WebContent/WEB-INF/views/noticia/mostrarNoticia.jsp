<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${noticia.titulo_noticia}</title>
<style>
div {
	width: 350px;
}
</style>

</head>
<body>
	<h5>${noticia.secao.titulo_secao}</h5>
	<h5>${noticia.data_noticia}</h5>
	<br />

	<img
		src="<c:url value="/resources/images/${noticia.titulo_noticia}.png" />"
		width="700" height="300" />
	<br />
	<h1>${noticia.titulo_noticia}</h1>
	${noticia.subtitulo_noticia}
	<h6>Autor:${noticia.jornalista.nome_usuario}</h6>
	<div class="div">
		${noticia.texto_noticia}
	</div>

	<hr width="60%" align="left" />
	<br />
	<h3>Comentário:</h3>
	<form action="inserirComentario" method="post">
		<input type="hidden" name="id_usuario"
			value="${usuario_logado.id_usuario}" /> <input type="hidden"
			name="id_noticia" value="${noticia.id_noticia}" /> Texto:<br />
		<textarea rows="4" cols="50" name="texto_comentario"></textarea>
		<br />
		<br /> <input type="submit" value="Comentar" />
	</form>
	<c:forEach var="comentario" items="${comentarios}">
		<hr width="60%" align="left" />
		<br />
		<h4>
			<img
				src="<c:url value="/resources/images/${comentario.usuario.login}.png" />"
				width="50" height="50" /> ${comentario.usuario.nome_usuario}
		</h4>
		<p>${comentario.texto_comentario}</p>
		<hr width="60%" align="left" />
		<br />
	</c:forEach>
	<a href="home">Voltar</a>
</body>
</html>