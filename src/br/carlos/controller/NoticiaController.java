package br.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.SecaoDAO;
import br.carlos.dao.UsuarioDAO;
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
				model.addAttribute("noticia",n);
				return "noticia/mostrarNoticia";
			}
		}
		return "redirect:paginaPrincipal";
	}	
}
