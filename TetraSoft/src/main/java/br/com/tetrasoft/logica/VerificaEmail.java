package br.com.tetrasoft.logica;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;

@WebServlet("/validaEmail")
public class VerificaEmail extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServerException {
		//recupera Email
		String email = req.getParameter("email");
		Cadastro cadastro;
		String status;
		// passe a conexão no construtor
		
		DaoCadastro dao = new DaoCadastro();
		try{
			
			cadastro = dao.findOne("select c from Cadastro c where c.email = ?", email); 
			System.out.println(cadastro.getEmail());
			if(cadastro.getEmail()=="")
				res.setStatus(200);
			else
				res.setStatus(500);
		}catch (javax.persistence.NoResultException e){
			status = "erro";
			
		}
		//Adiciona um atributo do Objeto a ser alterado
		

	}
}