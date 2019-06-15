package es.mpaxe.sga.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.idUsuario"),
	@NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
	@NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
	@NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
})
@Table(name = "Usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "username")
	private String username;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "password")
	private String password;
	
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
	@ManyToOne
	private Persona persona;
	
	public Usuario() {
	}
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Usuario(Integer idUsuario, String username, String password) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password, Persona persona) {
		this.username = username;
		this.password = password;
		this.persona = persona;
	}
	
	public Usuario(Integer idUsuario, String username, String password, Persona persona) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.persona = persona;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario otro = (Usuario) obj;
		if((this.idUsuario == null && otro.idUsuario != null) || 
		   (this.idUsuario != null && !this.idUsuario.equals(otro.idUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", persona="
				+ persona + "]";
	}
	
	
}
