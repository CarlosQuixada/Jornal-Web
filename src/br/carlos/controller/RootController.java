package br.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.SecaoDAO;
import br.carlos.model.Noticia;
import br.carlos.model.Secao;

@Controller
public class RootController {
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier("secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/")
	public String paginaPrincipal(Model model){
		List<Noticia> noticias = nDAO.listarNoticia();
		List<Secao> secoes = sDAO.listarSecao();
		
		model.addAttribute("noticias",noticias);
		model.addAttribute("secoes",secoes);
		
		return"paginaPrincipal";
	}
	
	@RequestMapping("/home")
	public String home(Model model){
		List<Noticia> noticias = nDAO.listarNoticia();
		List<Secao> secoes = sDAO.listarSecao();
		
		model.addAttribute("noticias",noticias);
		model.addAttribute("secoes",secoes);
		
		return"paginaPrincipal";
	}
}
