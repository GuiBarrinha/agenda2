<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">

</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="Botao1">Novo contatos</a>
	<a href="report" class="Botao2">Relatório</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Endereco</th>
				<th>Estado</th>
				<th>data aniversario</th>
				<th>Opcões</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getEndereco()%></td>
				<td><%=lista.get(i).getEstado()%></td>
				<td><%=lista.get(i).getDataNiver()%></td>

				<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="Botao1">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		<script src="scripts/confirmador.js"></script>
	</table>

</body>
</html>