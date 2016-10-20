package br.com.tetrasoft.logica;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.dao.DaoCadastro;
import br.com.tetrasoft.entity.Cadastro;
import br.com.tetrasoft.entity.Cadastro.Sexo;

@WebServlet("/updateContato")
public class UpdateContato extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		// monta um objeto contato
				Cadastro contato = new Cadastro();
				contato.setIdCadastro(Long.parseLong(request.getParameter("id")));
				contato.setNome(request.getParameter("nome"));
				contato.setEndereco(request.getParameter("endereco"));
				contato.setEmail(request.getParameter("email"));
				contato.setTelefone(request.getParameter("telefone"));
				contato.setSexo(request.getParameter("sexo").equals("MASCULINO")? Sexo.MASCULINO : Sexo.FEMININO);
				
		
		// passe a conexão no construtor
		try {
		DaoCadastro dao = new DaoCadastro();
		dao.update(contato);
		System.out.println("Alterando arquivo..");
		
		
		RequestDispatcher rd = request
		        .getRequestDispatcher("tetra?logica=ListarContatos");
			rd.forward(request,response);
		} catch (ServletException e) {
			System.out.println("Erro ao redirecionar a pagina");
			e.printStackTrace();
		}

	}

}
