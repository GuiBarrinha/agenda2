<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<!--form action="Controller" method="get" -->
	<form name="frmContato" action="update">

		<table>
			<tr>
				<td><input type="text" name="idcon" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>

			<tr>
				<td><input type="text" name="fone" class="Caixa2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="endereco" class="Caixa1"
					value="<%out.print(request.getAttribute("endereco"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="estado" class="Caixa1"
					value="<%out.print(request.getAttribute("estado"));%>"></td>
			</tr>
			<tr>
				<td><input type="date" name="dataNiver"
					value="<%out.print(request.getAttribute("dataNiver"));%>"></td>
			</tr>

		</table>
		<input type="button" class="Botao1" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>