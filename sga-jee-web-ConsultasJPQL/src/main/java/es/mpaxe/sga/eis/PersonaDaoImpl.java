package es.mpaxe.sga.eis;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import es.mpaxe.sga.domain.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {

    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;

    
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    
    public void deletePersona(Persona persona) {
        em.remove(em.merge(persona));
    }
}