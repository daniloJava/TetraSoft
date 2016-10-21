
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
		
		search(value.concat("__nome"));
		
	});
	
	$('#searchEmail').keyup(function (){
		var value = $(this).val();
		
		search(value.concat("__email"));
		
	});
	
	
});

function search(value){
	
	var url;
	if(value != ""){
		//se tiver algo preenchido ele leva pra outra Url, passando o valor do titulo e o numero d apagina
		url = "/TetraSoft/tetra?logica=ListarContatos&valor=" + value ;
	}else{
		url = "TetraSoft/tetra?logica=ListarContatos";
		
	}
	
	
	$('#tableAjax').load(url, function(response, status, xhr) {
		if (status == "error") {
			var msg = "Sorry but there was an error: ";
			$("#info").html(msg + xhr.status + " " + xhr.statusText);
		}
		
	});
	
}


