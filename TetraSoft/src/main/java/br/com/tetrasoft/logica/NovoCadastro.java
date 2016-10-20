package br.com.tetrasoft.logica;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;
import br.com.tetrasoft.entity.Cadastro.Sexo;

@WebServlet("/novoContato")
public class NovoCadastro extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		// fazendo a convers�o da data.

		// monta um objeto contato
		Cadastro contato = new Cadastro();
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setSexo(request.getParameter("sexo").equals("MASCULINO")? Sexo.MASCULINO : Sexo.FEMININO);
		
		// salva o contato
		try {
			
			DaoCadastro dao = new DaoCadastro();
			dao.save(contato);
			RequestDispatcher rd = request
			        .getRequestDispatcher("cadastro.jsp");
			rd.forward(request,response);
			
		} catch (ServletException e) {
			System.out.println("Erro ao redirecionar a pagina");
			e.printStackTrace();
		}
	}

}
