package br.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.carlos.dao.SecaoDAO;
import br.carlos.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	@Qualifier("secaoDAO")
	private SecaoDAO sDAO;
	
	@RequestMapping("/cadastrarSecaoFormulario")
	public String cadastrarSecaoFormulario(){
		return "secao/cadastrarSecaoFormulario";
	}
	
	@RequestMapping("/cadastrarSecao")
	public String cadastrarSecao(Secao secao,Model model){
		sDAO.inserirSecao(secao);
		model.addAttribute("secao",secao);
		return"secao/secaoInseridaOK";
	}
	
	@RequestMapping("/mostrarSecao")
	public String mostrarSecao(Model model){
		List<Secao> secoes = sDAO.listarSecao();
		model.addAttribute("secoes",secoes);
		return "secao/mostrarSecao";
	}
}
