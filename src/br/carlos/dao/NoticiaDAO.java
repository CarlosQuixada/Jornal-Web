package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.carlos.model.Noticia;

@Repository
public class NoticiaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirNoticia(Noticia notic){
		manager.persist(notic);
	}
	
	public void alterarNoticia(Noticia notic){
		manager.merge(notic);
	}
	
	public List<Noticia> listarNoticia(){
		String hql = "select n from noticia as n";
		return manager.createQuery(hql,Noticia.class).getResultList();
	}
	
	public void apagarNoticia(Long id){
		Noticia notic = this.recuperarNoticia(id);
		manager.remove(notic);
	}
	
	public Noticia recuperarNoticia(Long id){
		return manager.find(Noticia.class, id);
	}
}
