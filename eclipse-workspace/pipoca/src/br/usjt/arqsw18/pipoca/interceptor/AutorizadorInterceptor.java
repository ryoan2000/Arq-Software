package br.usjt.arqsw18.pipoca.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response,
	Object controller) throws Exception {
	if(request.getSession().getAttribute("usuarioLogado") != null) {
	return true;
	}
	response.sendRedirect("loginForm");
	return false;
	}
}
