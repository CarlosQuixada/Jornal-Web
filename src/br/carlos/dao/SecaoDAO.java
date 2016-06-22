package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.carlos.model.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirSecao(Secao secao){
		manager.persist(secao);
	}
	
	public void alterarSecao(Secao secao){
		manager.merge(secao);
	}
	
	public List<Secao> listarSecao(){
		String hql = "select s from secao as s";
		return manager.createQuery(hql,Secao.class).getResultList();
	}
	
	public void apagarSecao(Long id){
		Secao secao = this.recuperarSecao(id);
		manager.remove(secao);
	}
	
	public Secao recuperarSecao(Long id){
		return manager.find(Secao.class, id);
	}
}
