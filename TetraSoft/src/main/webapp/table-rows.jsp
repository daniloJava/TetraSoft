<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>

function atualizar(idContato) {
	var url = "tetra?logica=UpdateContato&id=" + idContato;
	
	$("#myModal").load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
});
}
</script>	


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
  				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> editar
			</a> 
			| <a
				href="tetra?logica=RemoverLogica&id=${contato.idCadastro}">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Remover</a>
			</td>
			<!--  -->
		</tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr>
		<th colspan="4"><c:forEach var="p" begin="1"
				end="${page.totalPages}">
				<c:choose>
					<c:when test="${ (p - 1) eq page.number }">
						<button id="button_${p}" disabled="disabled" value="${p}">${p}</button>
					</c:when>
					<c:otherwise>
						<button id="button_${p}" value="${p}">${p}</button>
					</c:otherwise>
				</c:choose>
			</c:forEach></th>
	</tr>

</tfoot>
	
	<div id="modalUpdate">
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>
						<span class="glyphicon glyphicon-lock"></span> Alterar contato -
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form action="updateContato" method="POST"
						class="form-horizontal">
						<!-- Abre formulário -->
						<!--Campo para Nome -->
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">Nome:</label>
							<div class="col-sm-10">
								<input type="text" name="nome" class="form-control"
									id="inputName" placeholder="Digite seu Nome" required>
							</div>
						</div>

						<!--Campo do Email -->
						<div class="form-group">
							<label for="exampleInputEmail1" class="col-sm-2 control-label">E-mail:</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="exampleInputEmail1"
									name="email" placeholder="Email" required>
							</div>
						</div>

						<!--Campo do Endereco -->
						<div class="form-group">
							<label for="Endereco" class="col-sm-2 control-label">Endereço:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="Endereco"
									name="endereco" placeholder="Digite seu Endereco" required>
							</div>
						</div>

						<!--Campo do Telefone -->
						<div class="form-group">
							<label for="Telefone" class="col-sm-2 control-label">Telefone:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="Telefone"
									name="telefone" placeholder="Telefone" required>
							</div>
						</div>

						<!--Campo do Radio Sexo -->
						<div class="form-group">
							<label for="Sexo" class="col-sm-2 control-label">Sexo: </label> <label
								class="radio-inline"> <input type="radio" name="sexo"
								id="masculino" value="MASCULINO"> maculino
							</label> <label class="radio-inline"> <input type="radio"
								name="sexo" id="feminino" value="FEMININO"> feminino
							</label>
						</div>

						<div class="form-group">
							<label for="Sexo" class="col-sm-2 control-label">
								Newsletter: </label> <label class="checkbox-inline"> <input
								type="checkbox"> sim
							</label>
						</div>

						<button type="submit" class="btn btn-primary btn-lg">salvar</button>

					</form>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>

		</div>
	</div>

</div>




