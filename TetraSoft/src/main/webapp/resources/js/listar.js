
/**quando le o documentom e le chama nosso função criada.
 * Exemplificando o metod on, ele recebe a ação, recebe qual a proprierada e 
 * uma função.
 * 
 * 
 */
$(document).ready(function () {
		
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
		}	
	});
	
});

function search(value){
	
	var url;
	if(value.length > 0){
		//se tiver algo preenchido ele leva pra outra Url, passando o valor do titulo e o numero d apagina
		url = "/TetraSoft/tetra?logica=ListarContatos&valor=" + value ;
	}else{
		url = "/TetraSoft/tetra?logica=ListarContatos";
	}
	
	
	$('#tableAjax').load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
		
	});
}

