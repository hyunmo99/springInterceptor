package com.spring.springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

	@RequestMapping(value = "/message/{msgFlag}", method = RequestMethod.GET)
	public String getMessage(Model model,
			@PathVariable String msgFlag,
			@RequestParam(name="mid", defaultValue = "", required = false) String mid
		) {
		
		if(msgFlag.equals("hoewonInputOk")) {
			model.addAttribute("message", mid + "님 회원에 정상적으로 가입되었습니다.");
			model.addAttribute("url", "/study1/mapping/test35?mid="+mid);
		}
		else if(msgFlag.equals("hoewonInputNo")) {
			model.addAttribute("message", "회원 가입 실패");
			model.addAttribute("url", "/study1/mapping/menu");
		}
		else if(msgFlag.equals("loginOk")) {
			model.addAttribute("message", mid + "님 로그인 성공");
			model.addAttribute("url", "/member/memberMain");
		}
		else if(msgFlag.equals("loginNo")) {
			model.addAttribute("message", "로그인 실패");
			model.addAttribute("url", "/");
		}
		else if(msgFlag.equals("logout")) {
			model.addAttribute("message", mid + "님 로그아웃 되었습니다.");
			model.addAttribute("url", "/");
		}
		else if(msgFlag.equals("loginError")) {
			model.addAttribute("message", "로그인후 사용하세요");
			model.addAttribute("url", "/");
		}
		else if(msgFlag.equals("adminNo")) {
			model.addAttribute("message", "이곳은 관리자 영역입니다. 등급을 확인하세요");
			model.addAttribute("url", "/member/memberMain");
			}
		else if(msgFlag.equals("levelNo")) {
			model.addAttribute("message", "등급을 확인하세요");
			model.addAttribute("url", "/member/memberMain");
		}
		
		return "include/message";
	}
	
}
