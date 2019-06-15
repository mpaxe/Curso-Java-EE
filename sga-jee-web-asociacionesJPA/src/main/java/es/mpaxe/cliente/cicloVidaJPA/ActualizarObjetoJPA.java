package es.mpaxe.cliente.cicloVidaJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;

public class ActualizarObjetoJPA {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		// Paso 1. Iniciamos la transacción 
		tx.begin();
		
		//Paso 2. Ejecutamos SQL del tipo select (el id debe existir en la base de dato)
		Persona persona1 = em.find(Persona.class, 4);
		
		//Paso 3. Cerramos la transacción 
		tx.commit();
		
		// Objeto enn estado detached
		log.debug("Objeto recuperado:"+ persona1);
		
		//Paso 4. Modificamos el objeto mediante lo métodos setter
		persona1.setTelefono("696696696");
		
		//Paso 5. Iniciamos segunda transacción
		EntityTransaction tx2 = em.getTransaction();
		tx2.begin();
		
		//Paso 6. Ejecutamos SQL. Usamos el método merge para actualizar el registo con los nuevos valores
		em.merge(persona1);
		
		//Paso 7. Finalizamos la segunda transacción
		tx2.commit();
		//Objeto en estado detached ya modificado
		log.debug("Objeto recuperado:"+ persona1);
	}
}
