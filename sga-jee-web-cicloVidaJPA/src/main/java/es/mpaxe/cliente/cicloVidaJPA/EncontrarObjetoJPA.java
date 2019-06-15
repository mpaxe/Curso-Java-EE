package es.mpaxe.cliente.cicloVidaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;

public class EncontrarObjetoJPA {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Paso 1. Inciamos la transacción
		tx.begin();
		
		//Paso 2. Ejecutamos SQL del tipo select (Le pasamos el id del objeto para recuperarlo)
		Persona persona1 = em.find(Persona.class, 4);
		
		//Paso 3. Termina la transacción
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto encontrado:"+ persona1);
	}
}
