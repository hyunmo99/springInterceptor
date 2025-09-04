package com.spring.springinterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
			System.out.println("preHandle :  Member컨드롤러 수행 전...");
			
			HttpSession session = request.getSession();
			int level = session.getAttribute("sLevel")==null ? 99 : (int) session.getAttribute("sLevel");
			
			if(level > 3) {
				request.getRequestDispatcher("/message/loginError").forward(request, response);
				return false;
			}
			
			return true;
		}

		public void postHandle(
				HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
			System.out.println("postHandle :  Member컨드롤러 수행 후...");
			
		}

}
