package br.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.carlos.dao.ClassificadoDAO;
import br.carlos.dao.NoticiaDAO;
import br.carlos.model.Classificado;
import br.carlos.model.Noticia;

@Transactional
@Controller
public class ClassificadoController {
	
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;
	
	@Autowired
	@Qualifier("classificadoDAO")
	private ClassificadoDAO clDAO;
	
	@RequestMapping("/cadastrarClassificadoFormulario")
	public String cadastrarClassificadoFormulario(){
		return "classificado/cadastrarClassificadoFormulario";
	}
	
	@RequestMapping("/cadastrarClassificado")
	public String cadastrarClassificado(Classificado clas,Model model){
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("noticias",noticias);
		clDAO.inserirClassificado(clas);
		return"paginaPrincipal";
	}
}
