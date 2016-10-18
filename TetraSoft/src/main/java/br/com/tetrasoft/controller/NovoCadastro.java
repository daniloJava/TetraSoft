package br.com.tetrasoft.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;

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

		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		

		// fazendo a conversão da data.


		// monta um objeto contato
		Cadastro contato = new Cadastro();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setSexo(Sexo.MASCULINO);

		// salva o contato
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			
			DaoCadastro dao = new DaoCadastro();
			dao.save(contato);
			RequestDispatcher rd = request
			        .getRequestDispatcher("/views/cadastro.jsp");
			rd.forward(request,response);
			
		} catch (ServletException e) {
			System.out.println("Erro ao redirecionar a pagina");
			e.printStackTrace();
		}
	}

}
