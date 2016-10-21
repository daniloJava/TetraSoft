<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<thead>
	<tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Telefone</th>
		<th>Ações</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${contatos}" var="contato">
		<tr>
			<td><strong>${contato.nome}</strong></td>
			<td>${contato.email}</td>
			<td>${contato.telefone}</td>
			<td>
			<a href="tetra?logica=MostraUpdateContato&id=${contato.idCadastro}"  id="editar" >
  				<span aria-hidden="true"></span> editar
			</a> 
			| <a
				href="tetra?logica=RemoverLogica&id=${contato.idCadastro}">
					<span aria-hidden="true"></span>Remover</a>
			</td>
			<!--  -->
		</tr>
	</c:forEach>
</tbody>
<tfoot>

</tfoot>
	
	