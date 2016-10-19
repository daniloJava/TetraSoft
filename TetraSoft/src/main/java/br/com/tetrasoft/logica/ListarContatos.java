package br.com.tetrasoft.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

public class ListarContatos implements Logica {

	/**
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  a pagina de lista contatos que vai aprentar os dados.
	 */
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// recupera a cone��o com o banco atravez do atributo do doFilter
		// connection.
		Connection connection = (Connection) req.getAttribute("connection");

		// cria um Dao e uma lista
		DaoCadastro dao = new DaoCadastro();
		List<Cadastro> contatos = dao.findAll();
		
		//Repassa a lista por atributo
		req.setAttribute("contatos", contatos);

		return "listar.jsp";
	}
}
