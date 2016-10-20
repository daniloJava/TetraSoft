package br.com.tetrasoft.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
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
//		Connection connection = (Connection) req.getAttribute("connection");
		
		String campoRecebido = req.getParameter("valor");
		String paginaDeRetorno;
		System.out.println(campoRecebido);
		List<Cadastro> contatos;
		// cria um Dao e uma lista
		DaoCadastro dao = new DaoCadastro();
		if(campoRecebido!=null){
			contatos = dao.findByNomeOrEmail(campoRecebido);
			paginaDeRetorno = "table-rows.jsp";
		}
		else{
			contatos = dao.findAll();
			paginaDeRetorno = "listar.jsp";
		}
		for (Cadastro cadastro : contatos) {
			System.out.println(cadastro.getNome());
		}
		
		//Repassa a lista por atributo
		req.setAttribute("contatos", contatos);

		System.out.println(paginaDeRetorno);
		
		return paginaDeRetorno;
	}
}
