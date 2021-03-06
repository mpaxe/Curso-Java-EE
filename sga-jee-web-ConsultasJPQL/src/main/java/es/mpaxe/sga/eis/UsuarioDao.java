package es.mpaxe.sga.eis;

import java.util.List;

import es.mpaxe.sga.domain.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> findAllUsuario();
	
	public Usuario findByIdUsuario(Usuario usuario);
	
	public Usuario findByUserName(Usuario usuario);
	
	public List<Usuario> findByPassword (Usuario usuario);
	
	public void addUsuario(Usuario usuario);
	
	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Usuario usuario);
}
