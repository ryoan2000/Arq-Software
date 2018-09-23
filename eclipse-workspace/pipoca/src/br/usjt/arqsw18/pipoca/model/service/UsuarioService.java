package br.usjt.arqsw18.pipoca.model.service;

import org.springframework.stereotype.Service;

import br.usjt.arqsw18.pipoca.model.dao.UsuarioDAO;
import br.usjt.arqsw18.pipoca.model.entity.Usuario;

@Service
public class UsuarioService {
	
	private UsuarioDAO dao;
	
	public UsuarioService(UsuarioDAO uDao){
		dao = uDao;
	}
	
	public Usuario buscarUsuario(int id) {
		return dao.buscarUsuario(id);
	}
	
}
