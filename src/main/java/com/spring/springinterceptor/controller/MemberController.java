package com.spring.springinterceptor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/login")
	public String loginGet() {
		log.info("==>> loginGet");
		return "member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(String mid, String pwd, int level,
			HttpSession session
		) {
		log.info("==>> loginPost");
		
		if(mid.substring(0, 1).toLowerCase().equals("a") && pwd.equals("1234")) {
			session.setAttribute("sMid", mid);
			session.setAttribute("sLevel", level);
			
			String strLevel = "";
			if(level == 0) strLevel = "관리자";
			else if(level == 1) strLevel = "우수회원";
			else if(level == 2) strLevel = "정회원";
			else if(level == 3) strLevel = "준회원";
			session.setAttribute("strLevel", strLevel);
			
			return "redirect:/message/loginOk?mid="+mid;
		}
		else return "redirect:/message/loginNo";
		
	}
	
	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		log.info("==>> logoutGet");
		
		String mid = (String) session.getAttribute("sMid");
		
		session.invalidate();
		
		return "redirect:/message/logout?mid="+mid;
	}
	
	@GetMapping("/idCheck")
	public String idCheckGet() {
		log.info("==>> idCheckGet");
		return "member/idCheck";
	}
	
	@GetMapping("/nickCheck")
	public String nickCheckGet() {
		log.info("==>> nickCheckGet");
		return "member/nickCheck";
	}
	
	@GetMapping("/join")
	public String joinGet() {
		log.info("==>> joinGet");
		return "member/join";
	}
	
	@GetMapping("/joinOk")
	public String joinOkGet() {
		log.info("==>> joinOkGet");
		return "member/joinOk";
	}
	
	@GetMapping("/memberMain")
	public String memberMainGet(Model model, HttpSession session) {
		log.info("==>> memberMainGet");
		
		String sId = session.getId();
		model.addAttribute("sId", sId);
		
		return "member/memberMain";
	}
	
	@GetMapping("/memberList")
	public String memberListGet() {
		log.info("==>> memberListGet");
		return "member/memberList";
	}
	
	@GetMapping("/memberUpdate")
	public String memberUpdateGet() {
		log.info("==>> memberUpdateGet");
		return "member/memberUpdate";
	}
	
	@GetMapping("/memberDelete")
	public String memberDeleteGet() {
		log.info("==>> memberDeleteGet");
		return "member/memberDelete";
	}
	
	@GetMapping("/memberSearch")
	public String memberSearchGet() {
		log.info("==>> memberSearchGet");
		return "member/memberSearch";
	}
	
}
