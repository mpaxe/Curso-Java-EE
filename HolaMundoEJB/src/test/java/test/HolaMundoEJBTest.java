package test;

import static org.junit.Assert.*;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Before;
import org.junit.Test;

import beans.HolaMundoEJB;

public class HolaMundoEJBTest {

	private static EJBContainer contenedor;
	private static Context contexto;
	private static HolaMundoEJB jndi;
	
	@Before
	public void iniciarContenedor() throws Exception{
		System.out.println("Iniciando EJB Container");
		contenedor = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
		jndi = (HolaMundoEJB) contexto.lookup("java:global/classes/HolaMundoEJB!beans.HolaMundoEJB");
	}
	@Test
	public void testAddNumbers() throws Exception {
		int dato1 = 3;
		int dato2 = 5;
		int resultado = jndi.sumar(dato1, dato2);
		assertEquals((dato1 + dato2), resultado);
		System.out.println("\nOperacion terminada, resultado: "+ resultado + "\n");
	}

}
