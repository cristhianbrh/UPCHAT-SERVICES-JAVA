package com.upchat.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	@Column(length = 30, nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private boolean esActivo;

	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@OneToMany(mappedBy = "rol")
	private List<Usuario> usuario;

	public Rol() {
		super();
		this.fechaRegistro = new Date();
		// TODO Auto-generated constructor stub
	}

	public Rol(int idRol, String descripcion, boolean esActivo, List<Usuario> usuario) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.esActivo = esActivo;
		this.fechaRegistro = new Date();
		this.usuario = usuario;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
