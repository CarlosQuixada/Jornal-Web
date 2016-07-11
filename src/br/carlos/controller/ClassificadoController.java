package br.carlos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.carlos.dao.ClassificadoDAO;
import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.SecaoDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Classificado;
import br.carlos.model.Noticia;
import br.carlos.model.Secao;
import br.carlos.model.Usuario;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;

	@Autowired
	@Qualifier("classificadoDAO")
	private ClassificadoDAO clDAO;

	@Autowired
	@Qualifier("secaoDAO")
	private SecaoDAO sDAO;

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;

	@RequestMapping("/cadastrarClassificadoFormulario")
	public String cadastrarClassificadoFormulario() {
		return "classificado/cadastrarClassificadoFormulario";
	}

	@RequestMapping("/cadastrarClassificado")
	public String cadastrarClassificado(Classificado clas, Model model) {
		if (clas.getTitulo_classificado().isEmpty() || clas.getTexto_classificado().isEmpty() || clas.getPreco() == null
				|| clas.getTelefone() == null) {
			return "redirect:cadastrarClassificadoFormulario";
		}

		List<Noticia> noticias = nDAO.listarNoticia();
		List<Secao> secoes = sDAO.listarSecao();

		model.addAttribute("noticias", noticias);
		model.addAttribute("secoes", secoes);
		
		

		clas.setMelhor_preco(clas.getPreco());
		clDAO.inserirClassificado(clas);
		return "paginaPrincipal";
	}

	@RequestMapping("/mostrarClassificado")
	public String mostrarClassificado(Model model) {
		List<Classificado> classificados = clDAO.listarClassificado();
		model.addAttribute("classificados", classificados);

		return "classificado/mostrarClassificado";
	}

	@RequestMapping("/realizarOferta")
	public String realizarOferta(Double valor,
			@RequestParam(value = "id_usuario_oferta", required = false) Long id_usuario_oferta,
			@RequestParam(value = "id_classificado", required = false) Long id_classificado, Model model) {
		if (valor == null) {
			return "redirect:mostrarClassificado";
		}
		Classificado clas = clDAO.recuperarClassificado(id_classificado);
		Usuario usu_oferta = uDAO.recuperarUsuario(id_usuario_oferta);

		if (valor > clas.getMelhor_preco() && valor > clas.getPreco()) {
			clas.setUsuario_oferta(usu_oferta);
			clas.setMelhor_preco(valor);
			
			Date data_oferta = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			clas.setData_oferta((formato.format(data_oferta)));
			System.out.println(clas.getData_oferta());
			
			clDAO.alterarClassificado(clas);
		}

		List<Classificado> classificados = clDAO.listarClassificado();
		model.addAttribute("classificados", classificados);
		return "redirect:mostrarClassificado";
	}
}
