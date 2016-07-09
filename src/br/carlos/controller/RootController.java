package br.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.carlos.dao.NoticiaDAO;
import br.carlos.model.Noticia;

@Controller
public class RootController {
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;
	
	@RequestMapping("/")
	public String home(Model model){
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("noticias",noticias);
		return"paginaPrincipal";
	}
	
	@RequestMapping("/home")
	public String home2(){
		return"paginaPrincipal";
	}
}
