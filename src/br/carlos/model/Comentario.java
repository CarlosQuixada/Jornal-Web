package br.carlos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "comentario")
public class Comentario {
	@Id
	@Column(name = "COM_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_comentario;
	private String texto_comentario;

	@ManyToOne
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;

	@Column(name = "USU_ID", insertable = false, updatable = false)
	private Long id_usuario;

	@ManyToOne
	@JoinColumn(name = "NOT_ID", referencedColumnName = "NOT_ID")
	private Noticia noticia;

	@Column(name = "NOT_ID", insertable = false, updatable = false)
	private Long id_noticia;

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getTexto_comentario() {
		return texto_comentario;
	}

	public void setTexto_comentario(String texto_comentario) {
		this.texto_comentario = texto_comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Long getId_noticia() {
		return id_noticia;
	}

	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}

}
