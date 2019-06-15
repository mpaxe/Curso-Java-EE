package com.mpaxe.cliente;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.mpaxe.pojos.Persona;
import com.mpaxe.service.PersonaServiceRemote;

public class ClientePersonaServiceConIP {

	public static void main(String[] args) {
		System.out.println("Iniciando la llamada al EJB desde el cliente\n");
		try {
			Properties properties = new Properties();
			properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
			properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
			properties.setProperty("java.naming.factory.state",
					"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
			// Cambia la IP del servidor de Glassfish (Opcinal)
			properties.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
			// Cambia el puerto del servidor Glassfish (Opcional)
			// properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
			Context jndi = new InitialContext(properties);
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi
					.lookup("java:global/sga-jee-app/PersonaServiceImpl!com.mpaxe.service.PersonaServiceRemote");

			List<Persona> personas = personaService.listarPersonas();

			for (Persona p : personas) {
				System.out.println(p);
			}
			System.out.println("\nFin de la llamada al EJB desde el cliente");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
}
