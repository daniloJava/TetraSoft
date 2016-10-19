
package br.com.tetrasoft.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

public class RemoverLogica implements Logica{
	
	/**
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  a pagina de lista contatos que vai aprentar os dados.
	 */
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//Recupera o ID para remoção no BD
		Long id = Long.parseLong(req.getParameter("id"));
		
		// recupera a coneção com o banco atravez do atributo do doFilter connection.
		Connection connection = (Connection) req
                .getAttribute("connection");
        
        // passe a conexão no construtor
        DaoCadastro dao = new DaoCadastro(); 
        
		System.out.println("Excluindo conato..");
		dao.delete(id);;
		
		return "tetra?logica=ListarContatos";
	}
}
