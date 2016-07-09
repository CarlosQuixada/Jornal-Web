package br.carlos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.carlos.dao.ComentarioDAO;
import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.SecaoDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Comentario;
import br.carlos.model.Noticia;
import br.carlos.model.Secao;
import br.carlos.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier("secaoDAO")
	private SecaoDAO sDAO;
	
	@Autowired
	@Qualifier("comentarioDAO")
	private ComentarioDAO cDAO;
	
	@RequestMapping("/cadastrarNoticiaFormulario")
	public String cadastrarNoticiaFormulario(Long id_secao,Model model){
		model.addAttribute("id_secao",id_secao);
		return "noticia/cadastrarNoticiaFormulario";
	}
	
	@RequestMapping("/cadastrarNoticia")
	public String cadastrarNoticia(Noticia notic,@RequestParam(value="id_secao",required=false)Long id_secao,@RequestParam(value="id_usuario",required=false)Long id_usuario){
		Usuario jorn = uDAO.recuperarUsuario(id_usuario);
		Secao secao = sDAO.recuperarSecao(id_secao);
		notic.setJornalista(jorn);
		notic.setSecao(secao);
		nDAO.inserirNoticia(notic);
		return "redirect:mostrarSecao";
	}
	
	@RequestMapping("/mostrarNoticia")
	public String mostrarNoticia(Long id_noticia,Model model){
		for(Noticia n : nDAO.listarNoticia()){
			if(n.getId_noticia().equals(id_noticia)){
				List<Comentario>comentarios = cDAO.listarComentario(id_noticia);
				model.addAttribute("noticia",n);
				model.addAttribute("comentarios",comentarios);
				return "noticia/mostrarNoticia";
			}
		}
		return "redirect:paginaPrincipal";
	}
	
	@RequestMapping("/listarNoticiaEditor")
	public String listarNoticiaEditor(Model model){
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("noticias",noticias);
		return"noticia/apagarNoticiaEditor";
	}
	
	@RequestMapping("/listarNoticiaJornalista")
	public String listarNoticiaJornalista(Long id_usuario,Model model){
		List<Noticia> noticias = nDAO.listarNoticiaJornalista(id_usuario);
		model.addAttribute("noticias",noticias);
		return"noticia/apagarNoticiaJornalista";
	}
	@RequestMapping("/apagarNoticiaJornalista")
	public String apagarNoticiaJornalista(Long id_noticia,HttpSession session,Model model) {
		List<Comentario> comentarios =cDAO.listarComentario(id_noticia);
		for(Comentario c : comentarios){
			cDAO.apagarComentario(c.getId_comentario());
		}
		nDAO.apagarNoticia(id_noticia);
		Usuario usu = (Usuario) session.getAttribute("usuario_logado");
		List<Noticia> noticias = nDAO.listarNoticiaJornalista(usu.getId_usuario());
		model.addAttribute("noticias",noticias);
		return"noticia/apagarNoticiaJornalista";
	}
	
	@RequestMapping("/apagarNoticiaEditor")
	public String apagarNoticiaEditor(Long id_noticia,Model model){
		List<Comentario> comentarios = cDAO.listarComentario(id_noticia);
		for(Comentario c : comentarios){
			cDAO.apagarComentario(c.getId_comentario());
		}
		nDAO.apagarNoticia(id_noticia);
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("noticias",noticias);
		return"noticia/apagarNoticiaEditor";
	}
}
