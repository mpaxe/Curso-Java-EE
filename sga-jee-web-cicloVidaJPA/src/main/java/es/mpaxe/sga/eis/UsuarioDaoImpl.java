package es.mpaxe.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.mpaxe.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext(unitName = "PersonaPU")
	
	EntityManager em;
	
	public List<Usuario> findAllUsuario() {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	public Usuario findByIdUsuario(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	public Usuario findByUserName(Usuario usuario) {
		return em.find(Usuario.class, usuario.getUsername());
	}

	public List<Usuario> findByPassword(Usuario usuario) {
		return em.createNamedQuery("Usuario.findByPassword").getResultList();
	}
	
	public void addUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);		
	}

	public void deleteUsuario(Usuario usuario) {
		em.remove(usuario);		
	}
}
