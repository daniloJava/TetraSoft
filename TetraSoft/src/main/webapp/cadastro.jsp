<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="novoContato" method="POST">
		<div class="form-group">
			<label for="inputName">Nome:</label> <input type="text" name="nome"
				class="form-control" id="inputName" placeholder="Digite seu Nome"
				required>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">E-mail</label> <input type="email"
				class="form-control" id="exampleInputEmail1" name="email"
				placeholder="Email" required>
		</div>

		<div class="form-group">
			<label for="Endereco">Endereço:</label> <input type="text"
				class="form-control" id="Endereco" name="endereco"
				placeholder="Digite seu Endereco" required>
		</div>
		<div class="form-group">

			Data Nascimento:
			<caelum:campoData id="dataNascimento" />
		</div>


		<button type="submit" class="btn btn-default">Gravar</button>
	</form>
	
</body>
</html>