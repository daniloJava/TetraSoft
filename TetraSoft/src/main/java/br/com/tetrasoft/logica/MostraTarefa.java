package br.com.tetrasoft.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

public class MostraTarefa implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Long id = Long.parseLong(req.getParameter("id"));

		
		// passe a conexão no construtor
		DaoCadastro dao = new DaoCadastro();

		Cadastro cadastro= dao.findById(id); 

		System.out.println("Alterando arquivo..");
		req.setAttribute("oldContato", cadastro);
		

		return "alteraCadastro.jsp";

	}

}
