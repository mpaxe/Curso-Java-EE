package es.mpaxe.cliente.cicloVidaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;

public class PersistirObjetoJPA {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Iniciamos la transacción 
		
		//Paso 1. Crear nuevo objeto en estado transitivo
		Persona persona1 = new Persona("David","Conte","Maldini","david@mail.com","954945954");
		
		//Paso 2. Iniciamos la transacción
		tx.begin();
		
		//Paso 3. Ejecutar SQL
		em.persist(persona1);
		
		//Paso 4. Commit/rollback
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto persistido:" + persona1);
		
		//Cerramos el Entity Manager
		em.close();
	}
}
