package test;

import static org.junit.Assert.*;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import com.mpaxe.pojos.Persona;
import com.mpaxe.service.PersonaService;
import org.junit.Before;
import org.junit.Test;

public class PersonaServiceTest {

	private PersonaService personaService;

	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) contenedor.getContext()
				.lookup("java:global/classes/PersonaServiceImpl!com.mpaxe.service.PersonaService");
		
	}

	@Test
	public void testEJBPersonaService() {
		System.out.println("Iniciando test EJB PersonaService");
		assertTrue(personaService != null);
		
		assertEquals(2, personaService.listarPersonas().size());
		
		System.out.println("El número de personas es igual a: "+personaService.listarPersonas().size());
		
		this.imprimirPersonas(personaService.listarPersonas());
		System.out.println("Fin test EJB PersonaService");
	}
	
	private void imprimirPersonas(List<Persona> personas) {
		for (Persona p: personas) {
			System.out.println(p);
		}
	}

}
