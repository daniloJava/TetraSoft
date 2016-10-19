<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar os usuários</title>

<link rel="shortcut icon"
	href="http://www.tetrasoft.com.br/wp-content/uploads/2013/11/favicon3.png">

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
		
		<div class="row">  <!-- Abre linha Resultado -->
			<div class="container">  <!-- Abre Conteudo Resultado -->
			
				<div class=" col-xs-6 col-md-2" id="menuCadastro"> <!-- Abre MENU -->
					<h4>Menu</h4>
					<h4>
						<a href="/TetraSoft/">CADASTRO</a>
					</h4>
					<h4>
						<a href="tetra?logica=ListarContatos">PESQUISA</a>
					</h4>
				</div> <!-- Fecha MENU -->
				
				
				<div class=" col-xs-12 col-md-8" id="pagina">  <!-- Abre Pagina -->

					<div class="row">  <!-- Abre uma linha Pagina -->
						<h4>Pesquisa De Clientes</h4>
						
						<div class="col-xs-12 col-md-8"> <!-- Abre Pesquisa -->
						
							<div class="form-group"> <!-- Abre campo de Pesquisa Nome-->
								<label for="inputName" class="col-sm-4 control-label">
									Filtro por Nome:
								</label>
								<div class="col-sm-8">
									<input type="text" name="nome" class="form-control"
										id="inputName" placeholder="Digite um nome" >
								</div>
							</div> <!-- Fecha campo de Pesquisa Nome -->
	
							<div class="form-group"> <!-- Abre campo de Pesquisa Email-->
								<label for="exampleInputEmail1" class="col-sm-4 control-label">Filtro
									por E-mail:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="exampleInputEmail1"
										name="email" placeholder="Email" required>
								</div>
							</div> <!-- Fecha campo de Pesquisa Email-->
						</div> <!-- Fecha Pesquisa -->
					</div> <!-- Fecha a linha Pagina -->
					
					
					<div class="row">  <!-- Abre uma linha para Resultado -->
						<h4>Resultados</h4>
							<hr>
							<table class="table table-striped table-hover">
								<tr>
									<th>Nome</th>
									<th>Email</th>
									<th>Telefone</th>
									<th>Ações</th>
								</tr>
								<c:forEach items="${contatos}" var="contato">
									<tr>
										<td><strong>${contato.nome}</strong></td>
										<td>${contato.email}</td>
										<td>${contato.telefone}</td>
										<td><a href="tetra?logica=MostraTarefa?id=${contato.idCadastro}">
												editar</a>
											| <a href="tetra?logica=RemoverLogica&id=${contato.idCadastro}">
												Remover</a></td>
	
									</tr>
								</c:forEach>
							</table>
					</div><!-- Fecha a linha para Resultado -->
					
				</div> <!-- Fecha Pagina -->
			</div> <!-- Fecha Conteudo Resultado -->
		</div> <!-- Fecha linha Resultado -->
	</div> <!-- Fecha todo Conteudo -->


</body>
</html>