package br.com.tetrasoft.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

public class VerificaEmail implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//recupera Email
		String email = req.getParameter("email");
		
		// passe a conexão no construtor
		DaoCadastro dao = new DaoCadastro();
		
		Cadastro cadastro = dao.findOne("select c from Cadastro c where c.email = ?", email); 
		//Adiciona um atributo do Objeto a ser alterado
		req.setAttribute("emailCadastrado", cadastro.getEmail());
		
		return "cadastro.jsp";

	}
}