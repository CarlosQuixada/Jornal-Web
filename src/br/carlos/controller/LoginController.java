package br.carlos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.carlos.dao.NoticiaDAO;
import br.carlos.dao.PapelDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Noticia;
import br.carlos.model.Papel;
import br.carlos.model.Usuario;
import br.carlos.security.Seguranca;
import sun.rmi.server.UnicastRef;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier("noticiaDAO")
	private NoticiaDAO nDAO;

	@Autowired
	@Qualifier("seguranca")
	private Seguranca seguranca;
	
	//PEGAR TODAS AS NOTICIAS PARA MOSTRAR NA PAGINA PRINCIPAL

	@RequestMapping("/loginFormulario")
	public String loginFormulario() {
		return "usuario/loginFormulario";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, Usuario usu,Model model) {
		List<Noticia> noticias = nDAO.listarNoticia();
		
		for(Noticia n : nDAO.listarNoticia()){
			System.out.println(n.getTitulo_noticia());
			System.out.println(n.getSubtitulo_noticia());
			System.out.println(n.getJornalista().getNome_usuario());
			System.out.println(n.getSecao().getTitulo_secao());
			System.out.println(n.getTexto_noticia());
			
		}
	
		Usuario ref = uDAO.recuperarUsuario(usu.getLogin());
		String senha_crip = seguranca.criptografar(usu.getSenha());
		usu.setSenha(senha_crip);

		if (ref != null) {
			if (ref.getSenha().equals(usu.getSenha())) {
				model.addAttribute("noticias",noticias);
				session.setAttribute("usuario_logado", ref);
				return "paginaPrincipal";
			}
		}
		return "redirect:loginFormulario";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
