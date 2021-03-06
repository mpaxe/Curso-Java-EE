package es.mpaxe.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import es.mpaxe.sga.domain.Persona;


@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

   
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Juan", "Perez", "Suarez", "jperez@gmail.com", "55668798"));
        personas.add(new Persona(2, "Martha", "Suarez", "Jimenez", "msuarez@mail.com", "566998811"));
        return personas;
    }

    
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    
    public void registrarPersona(Persona persona) {}

    
    public void modificarPersona(Persona persona) {}

    
    public void eliminarPersona(Persona persona) {}
}