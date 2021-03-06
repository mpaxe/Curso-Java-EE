package es.mpaxe.sga.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.mpaxe.sga.domain.Usuario;
import es.mpaxe.sga.servicio.UsuarioService;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioService usuarioServiceEjbLocal;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioServiceEjbLocal.listaUsuarios();
		System.out.println("usuarios: "+ usuarios);
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);;
	}
}
