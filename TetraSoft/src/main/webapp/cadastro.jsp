<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro</title>

<link type="text/css" href="resources/css/cadastroStyle.css" rel="stylesheet" />

</head>
<body>

	<div class="alinhando">
	<form action="novoContato" method="POST">
		<div class="form-group">
			<label for="inputName">Nome:</label> <input type="text" name="nome"
				class="form-control" id="inputName" placeholder="Digite seu Nome"
				required>
		

			<label for="exampleInputEmail1">E-mail</label> 
			<input type="email" class="form-control" id="exampleInputEmail1" name="email"
				placeholder="Email" required>

			<label for="Endereco">Endereço:</label> 
			<input type="text"
				class="form-control" id="Endereco" name="endereco"
				placeholder="Digite seu Endereco" required>
		
			<label for="Telefone">Telefone: </label> 
			<input type="text" class="form-control" id="Telefone" name="telefone"
				placeholder="Telefone" required>
			<div class="radio">
				<label> 
					<input type="radio" name="sexo" id="masculino" value="MASCULINO" > maculino
					<input type="radio" name="sexo" id="feminino" value="FEMININO" > feminino
				
				</label>
				</div>

				<div class="checkbox">
				<label> Newsletter: <input type="checkbox"> sim 
				</label>
			</div>

			

		</div>


		<button type="submit" class="btn btn-default">Gravar</button>
	</form>
		<a href="tetra?logica=ListarContatos"><button class="btn btn-default">Lista</button></a>
	</div>
	
</body>
</html>