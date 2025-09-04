package com.spring.springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/adminMain")
	public String adminMainGet() {
		log.info("==>>adminMain");
		return "admin/adminMain";
	}
	@GetMapping("/statistics")
	public String statistics() {
		log.info("==>>statistics");
		return "admin/statistics";
	}
	@GetMapping("/noticeWrite")
	public String noticeWriteGet() {
		log.info("==>>noticeWrite");
		return "admin/noticeWrite";
	}
}
