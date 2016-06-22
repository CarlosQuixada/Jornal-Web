<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${noticia.titulo_noticia}</title>
</head>
<body>
	<h5>${noticia.secao.titulo_secao}</h5>
	<h5>Data da Noticia</h5>
	<h1>${noticia.titulo_noticia}</h1>
	${noticia.subtitulo_noticia}
	 <h6>Autor:${noticia.jornalista.nome_usuario}</h6>
	<p>${noticia.texto_noticia}</p>
</body>
</html>