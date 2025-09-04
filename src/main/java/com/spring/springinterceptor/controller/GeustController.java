package com.spring.springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/guest")
public class GeustController {
	
	@GetMapping("/guestList")
	public String guestListGet() {
		log.info("==>> guestListGet");
		return "guest/guestList";
	}
	@GetMapping("/guestInput")
	public String guestInputGet() {
		log.info("==>> guestInput");
		return "guest/guestInput";
	}
	@GetMapping("/guestUpdate")
	public String guestUpdateGet() {
		log.info("==>> guestUpdate");
		return "guest/guestUpdate";
	}
	@GetMapping("/guestDelete")
	public String guestDeleteGet() {
		log.info("==>> guestDelete");
		return "guest/guestDelete";
	}
}
