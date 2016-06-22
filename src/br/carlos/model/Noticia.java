package br.carlos.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import sun.util.calendar.LocalGregorianCalendar.Date;

@Entity(name="noticia")
public class Noticia {
	@Id
	@Column(name="NOT_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_noticia;
	private String titulo_noticia;
	private String subtitulo_noticia;
	
	private String texto_noticia;
	
	@Type(type="timestamp")
	private Date data_noticia;
	
	@ManyToOne
	@JoinColumn(name="JORN_ID",referencedColumnName="USU_ID")
	private Usuario jornalista;
	
	@Column(name="JORN_ID",insertable=false,updatable=false)
	private Long id_jornalista;
	
	@OneToMany(mappedBy="noticia",targetEntity=Comentario.class,fetch=FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	@ManyToOne
	@JoinColumn(name="SEC_ID",referencedColumnName="SEC_ID")
	private Secao secao;
	
	@Column(name="SEC_ID",insertable=false,updatable=false)
	private Long id_secao;
	
	
	public Long getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}
	public String getTitulo_noticia() {
		return titulo_noticia;
	}
	public void setTitulo_noticia(String titulo_noticia) {
		this.titulo_noticia = titulo_noticia;
	}
	public String getSubtitulo_noticia() {
		return subtitulo_noticia;
	}
	public void setSubtitulo_noticia(String subtitulo_noticia) {
		this.subtitulo_noticia = subtitulo_noticia;
	}
	public String getTexto_noticia() {
		return texto_noticia;
	}
	public void setTexto_noticia(String texto_noticia) {
		this.texto_noticia = texto_noticia;
	}
	public Date getData_noticia() {
		return data_noticia;
	}
	public void setData_noticia(Date data_noticia) {
		this.data_noticia = data_noticia;
	}
	public Usuario getJornalista() {
		return jornalista;
	}
	public void setJornalista(Usuario jornalista) {
		this.jornalista = jornalista;
	}
	public Long getId_jornalista() {
		return id_jornalista;
	}
	public void setId_jornalista(Long id_jornalista) {
		this.id_jornalista = id_jornalista;
	}
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Secao getSecao() {
		return secao;
	}
	public void setSecao(Secao secao) {
		this.secao = secao;
	}
	public Long getId_secao() {
		return id_secao;
	}
	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}
	
	
}
