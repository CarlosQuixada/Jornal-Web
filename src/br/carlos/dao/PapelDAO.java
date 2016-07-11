package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.carlos.model.Papel;

@Repository
public class PapelDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserirPapel(Papel papel) {
		manager.persist(papel);
	}

	public void alterarPapel(Papel papel) {
		manager.merge(papel);
	}

	public List<Papel> listarPapel() {
		String hql = "select p from papel as p";
		return manager.createQuery(hql, Papel.class).getResultList();
	}

	public void apagarPapel(Long id) {
		Papel papel = this.recuperarPapel(id);
		manager.remove(papel);
	}

	public Papel recuperarPapel(Long id) {
		return manager.find(Papel.class, id);
	}
}
