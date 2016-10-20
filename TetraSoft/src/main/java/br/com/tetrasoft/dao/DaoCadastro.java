package br.com.tetrasoft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tetrasoft.entity.Cadastro;

/**
 * 
 * @author Danilo Silva
 *
 */
public class DaoCadastro extends DaoGenerico<Cadastro>{

	public DaoCadastro() {
		super(Cadastro.class);
	}
	
	public List<Cadastro> findByNomeOrEmail(String nome){
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();   //iniciando a transa��o
		
		String Jpql;
		if(nome.contains("__email")){
			Jpql = "select c from Cadastro c where c.email like '" +nome.replaceAll("__email", "")+ "%'";
		}else
			Jpql = "select c from Cadastro c where c.nome like '" +nome.replaceAll("__nome", "")+ "%'";
			
		
		Query query = manager.createQuery(Jpql);
		
		List<Cadastro> entities = query.getResultList();
		manager.getTransaction().commit(); 
		manager.close(); //liberar o objeto da memoria
		
		return entities;
	}
	

}
