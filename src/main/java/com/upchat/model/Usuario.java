package com.upchat.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Usuario {
	@Id
	@GeneratedValue()
	private int idUsuario;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(length = 50, nullable = false)
	private String correo;

	@Column(length = 50, nullable = false)
	private String telefono;

	@Column(length = 500, nullable = true)
	private String urlFoto;

	@Column(length = 100, nullable = true)
	private String nombreFoto;

	@Column(length = 100, nullable = false)
	private String clave;

	@Column(nullable = false)
	private boolean esActivo;

	@ManyToOne
	@JoinColumn(name = "rol", nullable = false)
	private Rol rol;

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Mensaje> mensajes;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StarCalification> stars;

	public Usuario() {
		super();
		this.fechaRegistro = new Date();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String nombre, String correo, String telefono, String urlFoto, String nombreFoto,
			String clave, boolean esActivo, Rol rol, List<Mensaje> mensajes,
			List<StarCalification> stars) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.urlFoto = urlFoto;
		this.nombreFoto = nombreFoto;
		this.clave = clave;
		this.esActivo = esActivo;
		this.rol = rol;
		this.fechaRegistro = new Date();
		this.mensajes = mensajes;
		this.stars = stars;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public List<StarCalification> getStars() {
		return stars;
	}

	public void setStars(List<StarCalification> stars) {
		this.stars = stars;
	}

}
