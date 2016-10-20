package br.com.tetrasoft.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

/**Classe para mostrar a pagina de Cadastro passando o Id.
 * 
 * @author Danilo Silva
 *
 */
public class MostraUpdateContato implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//recupera o ID
		Long id = Long.parseLong(req.getParameter("id"));
		
		// passe a conexão no construtor
		DaoCadastro dao = new DaoCadastro();
		
		Cadastro cadastro = dao.findById(id); 
		//Adiciona um atributo do Objeto a ser alterado
		req.setAttribute("oldContato", cadastro);
		
		return "alteraCadastro.jsp";

	}
}