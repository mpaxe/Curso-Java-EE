package es.mpaxe.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.mpaxe.sga.domain.Persona;
import es.mpaxe.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {

		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi
					.lookup("java:global/sga-jee/PersonaServiceImpl!es.mpaxe.sga.servicio.PersonaServiceRemote");

			List<Persona> personas = personaService.listarPersonas();

			for (Persona persona : personas) {
				System.out.println(persona);
			}
			System.out.println("\nFin llamada al EJB desde el cliente");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}