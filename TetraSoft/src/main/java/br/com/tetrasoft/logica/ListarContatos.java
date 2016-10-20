package br.com.tetrasoft.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

public class ListarContatos implements Logica {

	/**Implementadno o metodo Executa, 
	 * para que o Controller reconheça esse metodo e executa sem saber o que esta executando.
	 * 
	 * nesse caso fara com que retorne uma lista completa Ou
	 * uma lista apartir dos parametros passados
	 * 
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  a pagina de lista contatos que vai aprentar os dados.
	 */
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//Recupera o valor do campo por parametro "Inicio da Gambiarra"
		String campoRecebido = req.getParameter("valor");
		String paginaDeRetorno;

		List<Cadastro> contatos;
		
		// cria um Dao e uma lista
		DaoCadastro dao = new DaoCadastro();
		
		/*Se o Campo estiver diferente de Null quer dizer que foi inserido um valor em qualquer um dos
		campos de pesquisa , então ele chama a consulta e retorna pra a pagina table-rows.jsp
		*/
		if(campoRecebido!=null){
			contatos = dao.findByNomeOrEmail(campoRecebido);
			paginaDeRetorno = "table-rows.jsp";
		}
		else{// Retorna uma lista completa
			contatos = dao.findAll();
			paginaDeRetorno = "listar.jsp";
		}
		
		//Repassa a lista por atributo
		req.setAttribute("contatos", contatos);

		return paginaDeRetorno;
	}
}
