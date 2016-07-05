package br.carlos.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name="usuario")
public class Usuario {
	@Id
	@Column(name="USU_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_usuario;
	private String nome_usuario;
	private String email;
	private String login;
	private String senha;
	@Transient
	private Long status;
	
	@OneToMany(mappedBy="usuario_oferta",targetEntity=Classificado.class,fetch=FetchType.EAGER)
	private Collection<Classificado> classificados;
	
	@OneToMany(mappedBy="jornalista",targetEntity=Noticia.class,fetch=FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	@OneToMany(mappedBy="usuario",targetEntity=Comentario.class,fetch=FetchType.EAGER)
	private Collection<Comentario> comentarios;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "PAPEL_USUARIO", joinColumns = @JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID"), inverseJoinColumns = @JoinColumn(name = "PAP_ID", referencedColumnName = "PAP_ID"))
	private List<Papel> papeis;
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Collection<Classificado> getClassificados() {
		return classificados;
	}
	public void setClassificados(Collection<Classificado> classificados) {
		this.classificados = classificados;
	}
	public Collection<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
	public Collection<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Papel> getPapeis() {
		return papeis;
	}
	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
}
