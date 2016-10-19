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



</head>

<body>

	<fieldset>
		<legend>Lista de usuários</legend>
		<table>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
			<c:forEach items="${contatos}" var="contato">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.telefone}</td>
				<td><a href="tetra?logica=MostraTarefa?id=${contato.idCadastro}">editar</a></td>
				<td><a href="tetra?logica=RemoverLogica&id=${contato.idCadastro}">Remover</a></td>
				
			</tr>
			</c:forEach>
		</table>
	

	</fieldset>


</body>
</html>