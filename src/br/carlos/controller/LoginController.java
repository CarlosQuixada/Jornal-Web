package br.carlos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.SecaoDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Noticia;
import br.carlos.model.Papel;
import br.carlos.model.Secao;
import br.carlos.model.Usuario;
import br.carlos.security.Seguranca;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;

	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;

	@Autowired
	@Qualifier("secaoDAO")
	private SecaoDAO sDAO;

	@Autowired
	@Qualifier("seguranca")
	private Seguranca seguranca;

	@RequestMapping("/loginFormulario")
	public String loginFormulario() {
		return "usuario/loginFormulario";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, Usuario usu, Model model) {
		List<Noticia> noticias = nDAO.listarNoticia();
		List<Secao> secoes = sDAO.listarSecao();

		Usuario ref = uDAO.recuperarUsuario(usu.getLogin());
		String senha_crip = seguranca.criptografar(usu.getSenha());
		usu.setSenha(senha_crip);
		
		
		if (ref != null) {
			if (ref.getSenha().equals(usu.getSenha())) {
				model.addAttribute("noticias", noticias);
				model.addAttribute("secoes", secoes);
				session.setAttribute("usuario_logado", ref);
				return "paginaPrincipal";
			}
		}
		return "redirect:loginFormulario";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		List<Noticia> noticias = nDAO.listarNoticia();
		model.addAttribute("noticias", noticias);
		return "paginaPrincipal";
	}
}
