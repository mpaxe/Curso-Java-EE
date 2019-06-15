package es.mpaxe.cliente.asociaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;
import es.mpaxe.sga.domain.Usuario;

public class ClienteAsociacionesJPA {
	
	static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
		
		//Cerramos la conexión
		em.close();
		
		imprimrPersonas(personas);
	}
	
	private static void imprimrPersonas(List<Persona> personas) {
		//Imprimimos los las pesonas
		for(Persona persona: personas) {
			log.debug("Persona:"+ persona);
			for(Usuario usuario: persona.getUsuarios()) {
				log.debug("Usuario:"+ usuario);
			}
		}
	}

}
