package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.carlos.model.Classificado;

@Repository
public class ClassificadoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserirClassificado(Classificado clas) {
		manager.persist(clas);
	}

	public void alterarClassificado(Classificado clas) {
		manager.merge(clas);
	}

	public List<Classificado> listarClassificado() {
		String hql = "select c from classificado as c";
		return manager.createQuery(hql, Classificado.class).getResultList();
	}

	public void apagarClassificado(Long id) {
		Classificado clas = this.recuperarClassificado(id);
		manager.remove(clas);
	}

	public Classificado recuperarClassificado(Long id) {
		return manager.find(Classificado.class, id);
	}
}
