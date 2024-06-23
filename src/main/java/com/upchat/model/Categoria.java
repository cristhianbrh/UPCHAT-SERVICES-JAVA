package com.upchat.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;

	@Column(length = 100, nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy="categoria")
	private List<Mensaje> mensajes;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int idCategoria, String descripcion, List<Mensaje> mensajes) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.mensajes = mensajes;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes( List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
