package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/boards")
	public String board(Model model) {
		service.findAllProcess(model);
		return "board/list";
	}
	
	@GetMapping("/boards/new")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/boards/write")
	public String write(BoardDTO dto) {
		service.saveProcess(dto);
		return "redirect:/boards";
	}
	
	@GetMapping("/boards/{no}")
	public String detail(@PathVariable long no, Model model) {
		service.detailProcess(no,model);
	return "board/detail";
	}
}
