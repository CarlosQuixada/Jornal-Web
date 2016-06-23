package br.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.carlos.dao.ComentarioDAO;
import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Comentario;
import br.carlos.model.Noticia;
import br.carlos.model.Usuario;

@Transactional
@Controller
public class ComentarioController {
	
	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier("comentarioDAO")
	private ComentarioDAO cDAO;
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(Comentario comentario,Model model){
		Usuario usu = uDAO.recuperarUsuario(comentario.getId_usuario());
		Noticia not = nDAO.recuperarNoticia(comentario.getId_noticia());
		
		comentario.setUsuario(usu);
		comentario.setNoticia(not);
		
		model.addAttribute("noticia",not);
		
		cDAO.inserirComentario(comentario);
		return"noticia/mostrarNoticia";
	}
}
