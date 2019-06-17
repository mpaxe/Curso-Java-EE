package es.mpaxe.cliente.cicloVidaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;

public class EliminarObjetoJPA {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Paso 1. Iniciamos la transacción
		tx.begin();
		
		//Paso 2. Ejecutamos consulat SQL del tipo select
		Persona persona1 = em.find(Persona.class, 4);
		
		//Paso 3. Termina la transación
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto encontrado:"+ persona1);
		
		//Paso 4. Iniciamos la segunda transacción 
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		
		//Paso 5. Ejecuta SQL del tipo delete
		em.remove(persona1);
		
		//Paso 6. Cerramos la segunda transacción
		tx2.commit();
		
		//Objeto en estado detached ya eliminado
		log.debug("Objeto eliminado:"+ persona1);
	}
}
