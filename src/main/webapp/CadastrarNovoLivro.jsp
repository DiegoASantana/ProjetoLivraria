<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="Cadastrar" method="post">
	Código do livro:<input type="text" name="codLivro"><br>
	Titulo:<input type="text" name="titulo"><br>
	Autor:<input type="text" name="autor"><br>
	Categoria:<select name="Wcategoria">
			<option></option>
			<option>Arquitetura</option>
			<option>Design</option>
			<option>Informática</option>
			<option>Literatura universal</option>
			<option>Música e arte</option>
			<option>Terror</option>
		</select><br>
	Valor:<input type="text" name="valor"><br>
	<input type="submit" value="Cadastrar">
	</form>
</body>
</html>