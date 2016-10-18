package br.com.tetrasoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Fora de aclopamento a Fun��o � criar uma classe generica, que possa receber
 * qualquer tipo de classe e instanciar qualquer tipo de classe. atravez na
 * anota��o @WebServlet as paginas podem acessar qualquer tipo de logica.
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
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;

		try {
			// cria a classe conforme os dados recebidos
			Class<?> classe = Class.forName(nomeDaClasse);
			// instancia o objeto correto atravez de uma interface
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);

			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
		}
	}
}
