package es.mpaxe.sga.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE  p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE  p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellidoPaterno", query = "SELECT p FROM Persona p WHERE  p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Persona.findByApellidoMaterno", query = "SELECT p FROM Persona p WHERE  p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Persona.findByIdEmail", query = "SELECT p FROM Persona p WHERE  p.email = :email"),
    @NamedQuery(name = "Persona.findByIdTelefono", query = "SELECT p FROM Persona p WHERE  p.telefono = :telefono"),
    })
@Table(name = "Personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private int idPersona;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;

    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;
    
    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apePaterno, String apeMaterno,
            String email, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apePaterno;
        this.apellidoMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }
    
    public Persona(int idPersona, String nombre, String apePaterno, String apeMaterno,
            String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apePaterno;
        this.email = email;
    }
    
    public Persona(int idPersona, String nombre, String apePaterno, String apeMaterno,
            String email, String telefono) {
    	this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apePaterno;
        this.apellidoMaterno = apeMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apellidoPaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apellidoPaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apellidoMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apellidoMaterno = apeMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPersona;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (idPersona != other.idPersona)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
                + ", apePaterno=" + apellidoPaterno + ", apeMaterno=" + apellidoMaterno
                + ", email=" + email + ", telefono=" + telefono + "]";
    }
}