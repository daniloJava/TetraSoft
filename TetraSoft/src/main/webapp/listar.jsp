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
<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/listar.js"></script>



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
								<label for="searchNome" class="col-sm-4 control-label">
									Filtro por Nome:
								</label>
								<div class="col-sm-8">
									<input type="search" name="nome" class="form-control"
										id="searchNome" placeholder="Busca por Nome" >
								</div>
							</div> <!-- Fecha campo de Pesquisa Nome -->
	
							<div class="form-group"> <!-- Abre campo de Pesquisa Email-->
								<label for="searchEmail" class="col-sm-4 control-label">Filtro
									por E-mail:</label>
								<div class="col-sm-8">
									<input type="search" class="form-control" id="searchEmail"
										name="email" placeholder="Busca por Email" >
								</div>
							</div> <!-- Fecha campo de Pesquisa Email-->
							
						</div> <!-- Fecha Pesquisa -->
						
					</div> <!-- Fecha a linha Pagina -->


					<div class="row">
						<!-- Abre uma linha para Resultado -->
						<h4>Resultados</h4>
						<hr>
						<table id="tableAjax" class="table table-striped table-hover"">
							<jsp:include page="table-rows.jsp" />
						</table>
					</div>
					<!-- Fecha a linha para Resultado -->

				</div> <!-- Fecha Pagina -->
			</div> <!-- Fecha Conteudo Resultado -->
		</div> <!-- Fecha linha Resultado -->
	</div> <!-- Fecha todo Conteudo -->



								


</body>
</html>