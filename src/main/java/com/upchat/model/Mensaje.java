package com.upchat.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Mensaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMensaje;

	@Column(length = 100, nullable = false)
	private String asunto;

	@Column(columnDefinition = "nvarchar", nullable = true)
	private String messag;

	@Column(nullable = true)
	private Integer estrellas;

	@Column(length = 500, nullable = true)
	private String urlArchivo;

	@Column(length = 100, nullable = true)
	private String nombreArchivo;

	@Column(nullable = true)
	private Long idMensajeReferencia;

	@ManyToOne
	@JoinColumn(name = "categoria", nullable = false)
	private Categoria categoria;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@Column(nullable = false)
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "mensaje", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StarCalification> stars;

	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensaje(Long idMensaje, String asunto, String messag, Integer estrellas, String urlArchivo,
			String nombreArchivo, Long idMensajeReferencia, Categoria categoria, Date fechaRegistro, Boolean estado,
			Usuario usuario, List<StarCalification> stars) {
		super();
		this.idMensaje = idMensaje;
		this.asunto = asunto;
		this.messag = messag;
		this.estrellas = estrellas;
		this.urlArchivo = urlArchivo;
		this.nombreArchivo = nombreArchivo;
		this.idMensajeReferencia = idMensajeReferencia;
		this.categoria = categoria;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.usuario = usuario;
		this.stars = stars;
	}

	public Long getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(Long idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMessag() {
		return messag;
	}

	public void setMessag(String messag) {
		this.messag = messag;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public String getUrlArchivo() {
		return urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Long getIdMensajeReferencia() {
		return idMensajeReferencia;
	}

	public void setIdMensajeReferencia(Long idMensajeReferencia) {
		this.idMensajeReferencia = idMensajeReferencia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<StarCalification> getStars() {
		return stars;
	}

	public void setStars(List<StarCalification> stars) {
		this.stars = stars;
	}

}
