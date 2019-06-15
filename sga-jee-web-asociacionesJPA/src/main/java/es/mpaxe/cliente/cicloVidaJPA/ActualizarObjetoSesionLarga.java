package es.mpaxe.cliente.cicloVidaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;

public class ActualizarObjetoSesionLarga {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Paso 1. Iniciamos la transacción
		tx.begin();
		
		//Paso 2. Ejecutamos SQL del tipo select
		Persona persona1 = em.find(Persona.class, 1);
		log.debug("Objeto persistido:"+ persona1);
		
		//Paso 3. Modificamos el objeto a través de sus setter
		persona1.setApePaterno("Gutierrez");
		persona1.setApeMaterno("Gomez");
		
		//Paso 4. Terminamos la transacción
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto modificado:"+ persona1);
	}
}
