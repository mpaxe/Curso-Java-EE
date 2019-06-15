package com.mpaxe.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import com.mpaxe.pojos.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	public List<Persona> listarPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(1, "Alvaro", "Vera", "Casal", "mi@email.es", "999999999"));
		personas.add(new Persona(2, "Ely", "Ruiz", "Perez", "su@email.es", "666666666"));
		return personas;
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registrarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}
	
}
