<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="login.css">
</head>
<body>

	<div class="page">
		<form action="login" method="POST" class="formLogin">
			<h1>Login</h1>
			<p>Digite os seus dados de acesso no campo abaixo.</p>
			<label for="email">E-mail</label> <input type="email" name="email"
				placeholder="Digite seu e-mail" autofocus="true" /> <label
				for="password">Senha</label> <input type="password" name="password"
				placeholder="Digite seu e-mail" /> <a href="/">Esqueci minha
				senha</a> <input type="submit" value="Acessar" class="btn" />
			<div>
				<%
				String mensagem = (String) request.getAttribute("message");
				if (mensagem != null) {
					out.print(mensagem);
				}
				%>
			</div>
		</form>

	</div>

</body>
</html>