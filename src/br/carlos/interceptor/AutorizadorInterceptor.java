package br.carlos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		
		if(uri.endsWith("/") ||uri.endsWith("home")|| uri.endsWith("loginFormulario") || uri.endsWith("login") || uri.endsWith("inserirUsuarioFormulario") || uri.endsWith("inserirUsuario") || uri.endsWith("listarNoticiaSecao") || uri.endsWith("mostrarNoticia") || uri.endsWith("mostrarClassificado")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuario_logado") != null){
			return true;
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}
}
