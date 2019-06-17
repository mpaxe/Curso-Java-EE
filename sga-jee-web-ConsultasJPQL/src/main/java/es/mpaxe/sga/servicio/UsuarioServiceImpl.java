package es.mpaxe.sga.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.mpaxe.sga.domain.Usuario;
import es.mpaxe.sga.eis.UsuarioDao;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService {

	@EJB
	UsuarioDao usuarioDao;
	
	public List<Usuario> listaUsuarios() {
		return usuarioDao.findAllUsuario();
	}

	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		return usuarioDao.findByIdUsuario(usuario);
	}

	public Usuario encontrarUsuarioPorUsername(Usuario usuario) {
		return usuarioDao.findByUserName(usuario);
	}

	public List<Usuario> encontarUsuarioPorPassword(Usuario usuario) {
		return usuarioDao.findByPassword(usuario);
	}

	public void insertarUsuario(Usuario usuario) {
		usuarioDao.addUsuario(usuario);
	}

	public void editarUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		usuarioDao.deleteUsuario(usuario);
	}

}
