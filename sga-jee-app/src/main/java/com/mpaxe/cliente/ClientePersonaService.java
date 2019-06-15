package com.mpaxe.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.mpaxe.pojos.Persona;
import com.mpaxe.service.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {

		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi
					.lookup("java:global/sga-jee-app/PersonaServiceImpl!com.mpaxe.service.PersonaServiceRemote");

			List<Persona> personas = personaService.listarPersonas();

			for (Persona persona : personas) {
				System.out.println(persona);
			}
			System.out.println("\nFin llamada al EJB desde el cliente");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
}
