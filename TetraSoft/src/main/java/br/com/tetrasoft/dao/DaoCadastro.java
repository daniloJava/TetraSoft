package br.com.tetrasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tetrasoft.entity.Cadastro;

/**Classe DAO para o cadastro, instanciando a DAOGenerico
 * 
 * @author Danilo Silva
 *
 */
public class DaoCadastro extends DaoGenerico<Cadastro>{

	public DaoCadastro() {
		super(Cadastro.class);
	}
	
	/**Metodo de Recuperar ou o nome ou somente o E-mail para a pesquisa.
	 * 
	 * Ouve um pequeno probleminha com o Dano Generico, 
	 * foi assim que escrivi ess emetodo par aconsulta ao Banco
	 * 
	 * @param valor - é o que será procurado, tanto nome quanto e-mail
	 * @return
	 */
	public List<Cadastro> findByNomeOrEmail(String valor){
		//intancia um entity
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();   //iniciando a transacao
		
		/*Bloque que recebe a GAMBIARRA - 
		 * é sempre com base de analise, você passa a fazer algo funcionar, 
		 * mesmo que não seja o padrão correto. XD
		 * 
		 */
		String Jpql;
		//verifica na variavel recebida tem a "CHAVE" __email
		if(valor.contains("__email")){
			Jpql = "select c from Cadastro c where c.email like '" +valor.replaceAll("__email", "")+ "%'"; // Cria o JPPQL com e-mail e substitui a "Chave Email"
		}else
			Jpql = "select c from Cadastro c where c.nome like '" +valor.replaceAll("__nome", "")+ "%'";// Cria o JPQL para o nome e substitui a "Cave Nome"
			
		//Executa a Querri
		Query query = manager.createQuery(Jpql);
		
		List<Cadastro> entities = query.getResultList();//Lista o Resultado
		manager.getTransaction().commit(); //Comita
		manager.close(); //liberar o objeto da memoria
		
		return entities;
	}
	

}
