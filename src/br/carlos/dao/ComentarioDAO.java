package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.carlos.model.Comentario;

@Repository
public class ComentarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserirComentario(Comentario comen) {
		manager.persist(comen);
	}

	public void alterarComentario(Comentario comen) {
		manager.merge(comen);
	}

	public List<Comentario> listarComentario(Long id_not) {
		String hql = "select c from comentario as c where c.id_noticia = :var_idNoticia";
		Query query = manager.createQuery(hql);
		List<Comentario> comentarios = query.setParameter("var_idNoticia", id_not).getResultList();
		return comentarios;
	}

	public void apagarComentario(Long id) {
		Comentario comen = this.recuperarComentario(id);
		manager.remove(comen);
	}

	public Comentario recuperarComentario(Long id) {
		return manager.find(Comentario.class, id);
	}
}
