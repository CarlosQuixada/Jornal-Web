package br.carlos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.carlos.dao.PapelDAO;
import br.carlos.dao.UsuarioDAO;
import br.carlos.model.Papel;
import br.carlos.model.Usuario;
import br.carlos.security.Seguranca;
import br.carlos.util.FileUtil;

@Transactional
@Controller
public class UsuarioController {
	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO uDAO;

	@Autowired
	@Qualifier("papelDAO")
	private PapelDAO pDAO;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	@Qualifier("seguranca")
	private Seguranca seguranca;

	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario() {
		return "usuario/inserirUsuarioFormulario";
	}

	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usu, Model model,
			@RequestParam(value = "image", required = false) MultipartFile image) {
		if (usu.getNome_usuario().isEmpty() || usu.getEmail().isEmpty() || usu.getLogin().isEmpty()
				|| usu.getSenha().isEmpty()) {
			return "redirect:inserirUsuarioFormulario";
		}

		for (Usuario u : uDAO.listarUsuarios()) {
			if (u.getLogin().equals(usu.getLogin())) {
				return "redirect:inserirUsuarioFormulario";
			}
		}

		if (image != null && !image.isEmpty()) {
			String path = servletContext.getRealPath("/") + "resources/images/" + usu.getLogin() + ".png";
			FileUtil.saveFile(path, image);
		}

		Papel papel_leitor = pDAO.recuperarPapel(3L);
		List<Papel> papeis = new ArrayList<>();
		papeis.add(papel_leitor);

		String senha_crip = seguranca.criptografar(usu.getSenha());
		usu.setSenha(senha_crip);
		usu.setPapeis(papeis);
		uDAO.inserirUsuario(usu);
		model.addAttribute("usuario", usu);
		return "usuario/usuarioInseridoOK";
	}

	@RequestMapping("/mostrarUsuarios")
	public String mostrarUsuario(Model model) {
		List<Usuario> usuarios = uDAO.listarUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "usuario/mostrarUsuarios";
	}

	@RequestMapping("/cadastrarJornalistaFormulario")
	public String cadastrarJornalistaFormulario(Long id, Model model) {
		Usuario u = uDAO.recuperarUsuario(id);
		model.addAttribute("usuario", u);
		return "usuario/cadastrarJornalistaFormulario";
	}

	@RequestMapping("/cadastrarJornalista")
	public String cadastrarJornalista(Usuario usu, Model model) {
		Papel papel_jor = pDAO.recuperarPapel(2L);
		Usuario usuario = uDAO.recuperarUsuario(usu.getId_usuario());

		List<Papel> papeis = usuario.getPapeis();
		papeis.add(papel_jor);
		usuario.setPapeis(papeis);

		model.addAttribute("usuario_jorn", usuario);

		return "usuario/jornalistaCadastradoOK";
	}

	@RequestMapping("/gerenciarFuncao")
	public String gerenciarFuncao() {
		return "usuario/gerenciarFuncao";
	}
	
}
