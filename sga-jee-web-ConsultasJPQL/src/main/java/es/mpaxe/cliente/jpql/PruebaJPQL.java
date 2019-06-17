package es.mpaxe.cliente.jpql;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mpaxe.sga.domain.Persona;
import es.mpaxe.sga.domain.Usuario;

public class PruebaJPQL {

	static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		String jpql;
		Query q ;
		List<Persona> personas;
		Persona persona;
		Iterator iter;
		Object[] tupla;
		List<String> nombres;
		List<Usuario> usuarios;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
		EntityManager em = emf.createEntityManager();
		
		//1. Consulta todas las personas
		log.debug("\n1) Consulta todas las personas");
		jpql = "Select p from Persona p";
		personas = em.createQuery(jpql).getResultList();
		mostrarPersonas(personas);
		
		//2. Consulta de persona con id = 1
		log.debug("\n2) Consulta de persona con id = 13");
		jpql = "Select p from Persona p where p.idPersona = 13";
		persona = (Persona) em.createQuery(jpql).getSingleResult();
		log.debug(persona);
		
		//3. Consulta de persona por nombre = Marco
		log.debug("\n3) Consulta de la persona por nombre = Marco");
		jpql = "Select p from Persona p where p.nombre = 'Marco'";
		persona = (Persona) em.createQuery(jpql).getSingleResult();
		log.debug(persona);
		
		//4. Consulta datos individuales, se crea un array (tupla) de tipo object de 3 columnas:
		log.debug("\n4) Consulta datos individuales, se crea un array (tupla) de tipo object de 3 columnas");
		jpql = "Select p.nombre as Nombre, p.apellidoPaterno as Paterno, p.apellidoMaterno Materno from Persona p";
		iter = em.createQuery(jpql).getResultList().iterator();
		while(iter.hasNext()) {
			tupla = (Object[]) iter.next();
			String nombre = (String) tupla[0];
			String apellidoPaterno = (String) tupla[1];
			String apellidoMaterno = (String) tupla[2];
			log.debug(nombre + " " + apellidoPaterno + " " + apellidoMaterno);
		}
		
		//5) Obtiene el objeto Persona y el id, se crea un arreglo de tipo Object con 2 columnas:
        log.debug("\n5) Obtiene el objeto Persona y el idPersona, se crea un arreglo (tupla) de tipo Object con 2 columnas: ");
        jpql = "select p, p.idPersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (Integer) tupla[1];
            log.debug("Objeto persona:  " + persona);
            log.debug("id persona:  " + idPersona);
        }

        //6) Consulta de todas las Personas: 
        log.debug("\n6) Consulta de todas las Personas");
        jpql = "select new es.mpaxe.sga.domain.Persona( p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //7) Regresa el valor minimo y maximo del idPersona (Scalar results)
        log.debug("\n7) Regresa el valor minimo y maximo del idPersona (Scalar results)");
        jpql = "select min(p.idPersona) as MinId,  max(p.idPersona) as MaxId,  count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            log.debug("idMin:" + idMin + ", idMax:" + idMax + ", count:" + count);
        }

        //8) Cuenta los nombres de las personas que son distintos
        log.debug("\n8) Extrae el numero de personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("no. de personas con nombre distinto:" + contador);

        //9) Concatena y Convierte a mayusculas el nombre y apellido (depende de la base de datos):
        log.debug("\n9) Concatena y Convierte a mayusculas el nombre y apellido (depende de la base de datos):");
        jpql = "select CONCAT (p.nombre, ' ' , p.apellidoPaterno) as Nombre FROM Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombreCompleto : nombres) {
            log.debug(nombreCompleto);
        }

        //10) Obtiene el objeto alumno con id igual al parametro: 
        log.debug("\n10) Obtiene el objeto alumno con id igual al parametro 13:");
        int idPersona = 13;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        log.debug(persona);

        //11) Obtiene las personas que contenga una letra a, sin importar mayucula/minusculas:
        log.debug("\n11) Obtiene las personas que contenga una letra a, sin importar mayuscula/minusculas:");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:param1)";
        String cadena = "%a%";//es el caracter que utilizamos para el like
        q = em.createQuery(jpql);
        q.setParameter("param1", cadena);
        personas = q.getResultList();
        mostrarPersonas(personas);

        //12) Uso de between: 
        log.debug("\n12) ) Uso de between: ");
        jpql = "select p from Persona p where p.idPersona between 1 and 2";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //13) Uso del ordenamiento:
        log.debug("\n13)  Uso del ordenamiento:");
        jpql = "select p from Persona p where p.idPersona > 3 order by p.nombre desc, p.apellidoPaterno desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //14) Uso de un subquery (el soporte de esta funcionalidad depende de la base de datos utilizada)
        log.debug("\n14) Uso de un subquery (el soporte de esta funcionalidad depende de la base de datos utilizada)");
        jpql = "select p from Persona p where p.idPersona in ( select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);

        //15) Uso de join con lazy loading: 
        log.debug("\n15) Uso de join con lazy loading:");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);

        //16) Uso de left join con eager loading: 
        log.debug("\n16) Uso de left join con eager loading:");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);

       
    }

	private static void mostrarPersonas(List<Persona> personas) {
		for(Persona persona: personas) {
			log.debug(persona);
		}
	}
	
	private static void mostrarUsuarios(List<Usuario> usuarios) {
		for(Usuario usuario: usuarios) {
			log.debug(usuario);
		}
	}

}
