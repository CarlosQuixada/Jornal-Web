<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Noticia</title>
</head>
<body>
	<h2>Cadastrar Noticia - ${usuario_logado.nome_usuario}</h2>
	<form action="cadastrarNoticia" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id_secao" value="${id_secao}"/>
		<input type="hidden" name="id_usuario" value="${usuario_logado.id_usuario}"/>
		Titulo:<input type="text" name="titulo_noticia"/><br>
		Subtitulo:<input type="text" name="subtitulo_noticia"/><br/>
		Imagem:<input type="file" name="image"/><br/>
		Texto:<br/><textarea rows="4" cols="50" name="texto_noticia"></textarea><br/>
		<input type="submit" value="Cadastrar"/>
	</form>
</body>
</html>