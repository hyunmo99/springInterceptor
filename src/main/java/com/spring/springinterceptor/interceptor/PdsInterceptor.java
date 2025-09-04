package com.spring.springinterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PdsInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("preHandle : Pds 컨트롤러 수행 전...");
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 99 : (int) session.getAttribute("sLevel");

		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		if(level > 3) {
			request.getRequestDispatcher("/message/loginError").forward(request, response);
			return false;
		}
		else if(level == 3 || (level == 2 && !uri.equals("pdsList"))) {
			request.getRequestDispatcher("/message/levelNo").forward(request, response);
			return false;
		}
		
		
		return true;
	}

	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle : Pds 컨트롤러 수행 후...");
		
	}
	
	
}
