package es.mpaxe.sga.eis;

import java.util.List;

import es.mpaxe.sga.domain.Persona;

public interface PersonaDao {

	public List<Persona> findAllPersonas();

	public Persona findPersonaById(Persona persona);

	public Persona findPersonaByEmail(Persona persona);

	public void insertPersona(Persona persona);

	public void updatePersona(Persona persona);

	public void deletePersona(Persona persona);
}