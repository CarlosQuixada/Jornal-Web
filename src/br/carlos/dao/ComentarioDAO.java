package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.carlos.model.Comentario;

@Repository
public class ComentarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirComentario(Comentario comen){
		manager.persist(comen);
	}
	
	public void alterarComentario(Comentario comen){
		manager.merge(comen);
	}
	
	public List<Comentario> listarComentario(){
		String hql = "select c from comentario as c";
		return manager.createQuery(hql,Comentario.class).getResultList();
	}
	
	public void apagarComentario(Long id){
		Comentario comen = this.recuperarComentario(id);
		manager.remove(comen);
	}
	
	public Comentario recuperarComentario(Long id){
		return manager.find(Comentario.class, id);
	}
}
