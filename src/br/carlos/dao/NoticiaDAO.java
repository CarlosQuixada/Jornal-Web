package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public List<Noticia> listarNoticiaJornalista(Long id_usuario){
		String hql = "select n from noticia as n where n.id_jornalista = :var_id_jornalista";
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("var_id_jornalista", id_usuario).getResultList();
		return noticias;
	}
	
	public List<Noticia> listarNoticiaSecao(Long id_secao){
		String hql = "select n from noticia as n where n.id_secao = :var_id_secao";
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("var_id_secao", id_secao).getResultList();
		return noticias;
	}
	
	public void apagarNoticia(Long id){
		Noticia notic = this.recuperarNoticia(id);
		manager.remove(notic);
	}
	
	public Noticia recuperarNoticia(Long id){
		return manager.find(Noticia.class, id);
	}
}
