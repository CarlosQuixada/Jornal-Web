package br.carlos.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "secao")
public class Secao {
	@Id
	@Column(name = "SEC_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_secao;
	private String titulo_secao;
	private String descricao_secao;

	@OneToMany(mappedBy = "secao", targetEntity = Noticia.class, fetch = FetchType.EAGER)
	private Collection<Noticia> noticias;

	public Long getId_secao() {
		return id_secao;
	}

	public void setId_secao(Long id_secao) {
		this.id_secao = id_secao;
	}

	public String getDescricao_secao() {
		return descricao_secao;
	}

	public void setDescricao_secao(String descricao_secao) {
		this.descricao_secao = descricao_secao;
	}

	public Collection<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}

	public String getTitulo_secao() {
		return titulo_secao;
	}

	public void setTitulo_secao(String titulo_secao) {
		this.titulo_secao = titulo_secao;
	}

}
