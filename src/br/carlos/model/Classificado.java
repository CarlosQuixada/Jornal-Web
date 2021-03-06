package br.carlos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import sun.util.calendar.LocalGregorianCalendar.Date;

@Entity(name="classificado")
public class Classificado {
	@Id
	@Column(name="CLA_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_classificado;
	
	private String titulo_classificado;
	
	private String texto_classificado;
	
	private Double preco;
	
	private String telefone;
	
	private Double melhor_preco;
	
	@Type(type="timestamp")
	private Date data_oferta;
	
	@ManyToOne
	@JoinColumn(name="USU_ID",referencedColumnName="USU_ID")
	private Usuario usuario_oferta;
	
	@Column(name="USU_ID",insertable=false,updatable=false)
	private Long id_usuario_oferta;
	
	public Long getId_classificado() {
		return id_classificado;
	}
	public void setId_classificado(Long id_classificado) {
		this.id_classificado = id_classificado;
	}
	public String getTitulo_classificado() {
		return titulo_classificado;
	}
	public void setTitulo_classificado(String titulo_classificado) {
		this.titulo_classificado = titulo_classificado;
	}
	public String getTexto_classificado() {
		return texto_classificado;
	}
	public void setTexto_classificado(String texto_classificado) {
		this.texto_classificado = texto_classificado;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Double getMelhor_preco() {
		return melhor_preco;
	}
	public void setMelhor_preco(Double melhor_preco) {
		this.melhor_preco = melhor_preco;
	}
	public Date getData_oferta() {
		return data_oferta;
	}
	public void setData_oferta(Date data_oferta) {
		this.data_oferta = data_oferta;
	}
	public Usuario getUsuario_oferta() {
		return usuario_oferta;
	}
	public void setUsuario_oferta(Usuario usuario_oferta) {
		this.usuario_oferta = usuario_oferta;
	}
	public Long getId_usuario_oferta() {
		return id_usuario_oferta;
	}
	public void setId_usuario_oferta(Long id_usuario_oferta) {
		this.id_usuario_oferta = id_usuario_oferta;
	}
	
	
}
