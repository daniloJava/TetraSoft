package br.com.tetrasoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tetrasoft.logica.Logica;


/**Classe de Controller de Servlet Generico, capaz de receber e instanciar qualquer tipo de classe e
 * de forma pela URL.
 * 
 * @author Danilo Silva
 *
 */
@WebServlet("/tetra")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupera o paremetro passado pelas paginas com o nome de logica e
		// cria o pacote para criar o Objeto
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.tetrasoft.logica." + parametro;

		try {
			// cria a classe conforme os dados recebidos
			Class<?> classe = Class.forName(nomeDaClasse);
			// instancia o objeto correto atravez de uma interface
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			//Redireciona para a pagina
			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("Problemas na logica de Negocio.", e);
		}
	}
	
}
