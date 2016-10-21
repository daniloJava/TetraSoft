<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="widht=device-widht">
<title>Cadastro</title>

<link rel="shortcut icon" href="http://www.tetrasoft.com.br/wp-content/uploads/2013/11/favicon3.png">

<link type="text/css" href="resources/css/bootstrap/bootstrap.css"
	rel="stylesheet" />
<link type="text/css" href="resources/css/bootstrap/bootstrap-theme.css"
	rel="stylesheet" />
<link type="text/css" href="resources/css/bootstrap/bootstrap.css"
	rel="stylesheet" />
<link type="text/css" href="resources/css/cadastroStyle.css"
	rel="stylesheet" />

</head>
<body>
	
	<div class="conteudo"> <!-- Abre todo Conteudo -->
		<!-- Abre Cabeçalho -->
		<header id="header">
			<div class="row">
				<div class="container">
					<div class="col-xs-6 col-md-4">
					
						<a class="logo" href="http://www.tetrasoft.com.br">  <!-- Abre Link do Logo -->
							<img id="id_logo" class="logo-img"
									src="http://www.tetrasoft.com.br/wp-content/uploads/2013/11/Tetra-Soft-2.png" alt="Tetra">
						</a> <!-- Fecha Link do Logo -->
						
					</div>
					<div class="col-xs-12 col-md-8">
						<h2>Sistema Demonstração</h2>
					</div>
				</div>
			</div>
		</header> <!-- Fecha Cabeçalho -->
		
		<hr>
		
		<div class="row">  <!-- Abre linha Cadastro -->
			<div class="container">  <!-- Abre Conteudo Cadastro -->
			
				<div class=" col-xs-6 col-md-2" id="menuCadastro"> <!-- Abre MENU -->
					<h4>Menu</h4>
					<h4>
						<a href="/TetraSoft/">CADASTRO</a>
					</h4>
					<h4>
						<a href="tetra?logica=ListarContatos">PESQUISA</a>
					</h4>
				</div> <!-- Fecha MENU -->
				
				<div class=" col-xs-12 col-md-8" id="pagina"> <!-- Abre Pagina -->

					<div class="row">
						<h4>Cadastro De Clientes</h4>

						<form action="novoContato" method="POST" class="form-horizontal  col-md-8"> <!-- Abre formulário -->
							<!--Campo para Nome -->
							<div class="form-group"> 
								<label for="inputName" class="col-sm-2 control-label">Nome:</label>
								<div class="col-sm-10">
									<input type="text" name="nome" class="form-control" id="inputName" placeholder="Digite seu Nome" required>
								</div>
							</div>
							
							<!--Campo do Email -->
							<div class="form-group">
								<label for="exampleInputEmail1" class="col-sm-2 control-label">E-mail:</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="Email" required>
								</div>
							</div>
	
							<!--Campo do Endereco -->
							<div class="form-group">
								<label for="Endereco" class="col-sm-2 control-label">Endereço:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="Endereco" name="endereco" placeholder="Digite seu Endereco" required>
								</div>
							</div>
	
							<!--Campo do Telefone -->
							<div class="form-group">
								<label for="Telefone" class="col-sm-2 control-label">Telefone:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="Telefone" name="telefone" placeholder="Telefone" required>
								</div>
							</div>
							
							<!--Campo do Radio Sexo -->
							<div class="form-group">
								<label for="Sexo" class="col-sm-2 control-label">Sexo: </label>
								<label class="radio-inline"> 
									<input type="radio" name="sexo" id="masculino" value="MASCULINO"> 
									maculino
								</label> 
								<label class="radio-inline"> 
									<input type="radio" name="sexo" id="feminino" value="FEMININO"> 
									feminino
								</label>
							</div>
							
							
							<div class="form-group">
								<label for="newsletter" class="col-sm-2 control-label">
									Newsletter: 
								</label> 
								<label class="checkbox-inline"> 
									<input type="checkbox" id="newsletter" value="s" name="newsletter"> sim
								</label>
							</div>

							<button type="submit" class="btn btn-primary btn-lg">salvar</button>
							
						</form> <!-- Fecha formulário -->

					</div>
				</div> <!-- Fecha Pagina -->
				
			</div>  <!-- Fecha Conteudo Cadastro -->
			
		</div>  <!-- Fecha linha Cadastro -->
		
	</div>  <!-- Fecha todo Conteudo -->

</body>
</html>