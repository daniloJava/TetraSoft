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

/**De uma forma diferente,
 * essa classe e a proria Servlet
 * 
 * Atravez da Anota��o @WebServlet eu chamo o seu conteudo na pagina,
 * e automaticamente o metodo service � executado 
 * 
 * 
 * @author Danilo Silva
 *
 */
@WebServlet("/novoContato")
public class NovoCadastro extends HttpServlet {
	
	/**Metodo Sobrecarregado da Classe HttpServlet
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		// monta um objeto contato Recuperando os Valores pelo Request
		Cadastro contato = new Cadastro();
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setSexo(request.getParameter("sexo").equals("MASCULINO")? Sexo.MASCULINO : Sexo.FEMININO);
		contato.setNewsletter(request.getParameter("newsletter"));
		
		// salva o contato
		try {
			
			DaoCadastro dao = new DaoCadastro();
			dao.save(contato);
			
			//Redireciona para a pagina
			RequestDispatcher rd = request
			        .getRequestDispatcher("cadastro.jsp");
			rd.forward(request,response);
			
		} catch (ServletException e) {
			System.out.println("Erro ao redirecionar a pagina");
			e.printStackTrace();
		}
	}

}
