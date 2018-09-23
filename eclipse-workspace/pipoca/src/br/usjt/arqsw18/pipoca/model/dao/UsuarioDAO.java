package br.usjt.arqsw18.pipoca.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	EntityManager manager;	
	
	public Usuario buscarUsuario(int id) {
		return manager.find(Usuario.class, id);
	}
}
