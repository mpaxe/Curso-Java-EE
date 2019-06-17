package es.mpaxe.cliente.cascada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;
import es.mpaxe.sga.domain.Usuario;

public class PersistenciaCascadaJPA {
	
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//Creamos el objeto Persona
		Persona persona = new Persona("Marco", "Asensio", "Willemsen", "asensio@mail.com", "954954954");
		
		//Creamos el objeto Usuario
		Usuario usuario = new Usuario("MarAsen", "12345", persona);
		
		//Abrimos la transacción
		tx.begin();
		
		//Persistimos el segundo objeto, el primero lo hará en cascada
		em.persist(usuario);
		
		//Commit/Rollback
		tx.commit();
		
		//Objeto en estado detached
		log.debug("Objeto persistido Persona:"+ persona);
		log.debug("Objeto persistido Usuario:"+ usuario);
		
		//Cerramos entity manager
		em.close();
	}

}
