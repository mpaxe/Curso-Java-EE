package es.mpaxe.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import es.mpaxe.sga.domain.Persona;
import es.mpaxe.sga.eis.PersonaDao;


@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {
	
	@Inject
	private PersonaDao personaDao;

        
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

        
	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

        
	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

        
	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

        
	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

        
	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
}