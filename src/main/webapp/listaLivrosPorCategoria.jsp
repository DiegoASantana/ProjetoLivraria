<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%@ page import="servlet.LivroDao, servlet.Livro, java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1>Listagem de Livros</h1>
	
	<form action="Listar" name="categorias" method="get">
		<select name="categoria">
			<option>Selecione uma Categoria</option>
			<option value="Arquitetura">Arquitetura</option>
			<option value="Design">Design</option>
			<option value="Informatica">Informática</option>
			<option value="Literatura brasileira">Literatura brasileira</option>
			<option value="Literatura universal">Literatura universal</option>
			<option value="Musica e arte">Musica e arte</option>
		</select>
		<input type="submit" name="listar">
	</form>
	
</body>
</html>