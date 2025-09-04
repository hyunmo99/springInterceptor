package com.spring.springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/pds")
public class PdsController {
	
	@GetMapping("/pdsList")
	public String pdsListGet() {
		log.info("==>> pdsListGet");
		return "pds/pdsList";
	}
	@GetMapping("/pdsInput")
	public String pdsInputGet() {
		log.info("==>> pdsInput");
		return "pds/pdsInput";
	}
	@GetMapping("/pdsUpdate")
	public String pdsUpdateGet() {
		log.info("==>> pdsUpdate");
		return "pds/pdsUpdate";
	}
	@GetMapping("/pdsDelete")
	public String pdsDeleteGet() {
		log.info("==>> pdsDelete");
		return "pds/pdsDelete";
	}
}
