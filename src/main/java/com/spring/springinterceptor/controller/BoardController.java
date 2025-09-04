package com.spring.springinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/boardList")
	public String boardListGet() {
		log.info("==>> boardListGet");
		return "board/boardList";
	}
	@GetMapping("/boardInput")
	public String boardInputGet() {
		log.info("==>> boardInput");
		return "board/boardInput";
	}
	@GetMapping("/boardContent")
	public String boardContentGet() {
		log.info("==>> boardContent");
		return "board/boardContent";
	}
	@GetMapping("/boardUpdate")
	public String boardUpdateGet() {
		log.info("==>> boardUpdate");
		return "board/boardUpdate";
	}
	@GetMapping("/boardDelete")
	public String boardDeleteGet() {
		log.info("==>> boardDelete");
		return "board/boardDelete";
	}
}
