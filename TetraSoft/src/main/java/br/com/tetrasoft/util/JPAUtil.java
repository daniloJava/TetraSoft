package br.com.tetrasoft.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private EntityManagerFactory factory;
	private static JPAUtil instance;

	/**
	 * Construtor privado para n�o ser acessado fora da classe, e inicializado a
	 * unidade de persistencia que est� configurado no persistence.xml
	 * 
	 */
	private JPAUtil() {
		this.factory = Persistence.createEntityManagerFactory("TetraSoft");
	}

	/**
	 * For�ando a sincroniza��o atraves, de uma forma que se n�o tiver uma
	 * instancia, criar uma sen�o retornar a mesma instancia
	 * 
	 * @return JPAUtil - a propria instancia da classe.
	 */
	public static synchronized JPAUtil getInstance() {
		if (instance == null)
			instance = new JPAUtil();
		return instance;
	}

	/**
	 * Retornar uma conex�o.
	 * 
	 * @return EntityManager -
	 */
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
