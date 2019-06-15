package es.mpaxe.sga.servicio;

import java.util.List;

import javax.ejb.Local;

import es.mpaxe.sga.domain.Usuario;

@Local
public interface UsuarioService {

	public List<Usuario> listaUsuarios();
	
	public Usuario encontrarUsuarioPorId(Usuario usuario);
	
	public Usuario encontrarUsuarioPorUsername(Usuario usuario);
	
	public List<Usuario> encontarUsuarioPorPassword (Usuario usuario);
	
	public void insertarUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);

	public void eliminarUsuario(Usuario usuario);
}
