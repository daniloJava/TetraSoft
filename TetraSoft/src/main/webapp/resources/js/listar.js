
/**quando le o documentom e le chama nosso função criada.
 * Exemplificando o metod on, ele recebe a ação, recebe qual a proprierada e 
 * uma função.
 * 
 * 
 */
$(document).ready(function () {
	$(document).on('click', 'button[id*="button_"]', function (a){
		var pageNumber = $(this).val();
		tbody(pageNumber);
	});
	
	/**para cada tecla do telado precionada.
	 * ele recupera o valor texta com a expreção regular
	 * e chava a funçao search passando o valor
	 * 
	 */
	$('#searchNome').keyup(function (){
		var value = $(this).val();
		
		var exp = new RegExp('^[a-zA-Z0-9]');
		
		if (exp.test(value)){
			search(value.concat("__nome"));
		}else{
			tbody(1);
		}
	});
	
	$('#searchEmail').keyup(function (){
		var value = $(this).val();
		
		var exp = new RegExp('^[a-zA-Z0-9]');
		
		if (exp.test(value)){
			search(value.concat("__email"));
		}else{
			tbody(1);
		}	
	});
	
});

function search(value){
	
	var url = "/TetraSoft/tetra?logica=ListarContatos&valor=" + value + "&pagina=1";
	
	$('#tableAjax').load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
		
	});
}


/**Função JS pra criar a paginação via Ajax
 * 
 * ele recupera atravez do id uma resposta da função,
 * um status que deu errado ou não, e um Xhr que é a mensagem do erro
 * 
 * se der erro ele apresenta a mensagem de erro do Id #info
 * 
 * caso der tudo certo, ele reupera o botal e desabilita atravez do .attr
 * 
 * @param page
 * @returns
 */
function tbody(page){
	var url = "/blog/postagem/ajax/page/" + page;
	
	//recupera o valor que está no campo de busca
	var titulo = $('#search').val();
	
	//valida se tem alguma coisa preenchida,
	if(titulo.length > 0){
		//se tiver algo preenchido ele leva pra outra Url, passando o valor do titulo e o numero d apagina
		url = "/blog/postagem/ajax/titulo/" + titulo + "/page/" + page;
	}else
		// se estiver tudo vazio então continua com o fluxo normal.
		url = "/blog/postagem/ajax/page/" + page;

	$("#tableAjax").load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
		
//		if(status == "success"){
//			$('button').each(function() {
//				
//				var id = '#' + $(this).attr('id');
//				if($(id).attr('disabled') == 'disabled'){
//					$(id).removeAttr('disabled');
//				}
//			});
//		$('#button_' + page).attr('disabled', 'disabled');
//		}
	});
}
