package com.upchat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StarCalification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column()
	private int star;

	@ManyToOne
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "mensaje", nullable = false)
	private Mensaje mensaje;

	public StarCalification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StarCalification(int id, int star, Usuario usuario, Mensaje mensaje) {
		super();
		this.id = id;
		this.star = star;
		this.usuario = usuario;
		this.mensaje = mensaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

}
