package br.carlos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.carlos.model.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserirUsuario(Usuario usu){
		manager.persist(usu);
	}
	
	public void alterarUsuario(Usuario usu){
		manager.merge(usu);
	}
	
	public List<Usuario> listarUsuarios(){
		String hql = "select u from usuario as u";
		return manager.createQuery(hql,Usuario.class).getResultList();
	}
	
	public void apagarUsuario(Long id){
		Usuario usu = this.recuperarUsuario(id);
		manager.remove(usu);
	}
	
	public Usuario recuperarUsuario(Long id){
		return manager.find(Usuario.class, id);
	}
	
	public Usuario recuperarUsuario(String login){
		String hql = "select u from usuario as u where u.login = :var_login";
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("var_login", login).getResultList();
		if(usuarios.size() != 0){
			return usuarios.get(0);
		}
		return null;
	}
	
}
