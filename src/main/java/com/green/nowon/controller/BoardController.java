package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/boards")
	public String board(Model model,@RequestParam(defaultValue = "1") int page) {
		service.findAllProcess(model,page);
		return "board/list";
	}
	//게시판 글쓰기 페이지 이동
	@GetMapping("/boards/new")
	public String write() {
		return "board/write";
	}
	//게시판 글쓰기 페이지에서 글쓰기후 게시글페이지로이동
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
	//게시판 디테일 삭제
	@DeleteMapping("/boards/{no}")
	public String delete(@PathVariable("no")long no) {
		service.deleteProcess(no);
		return "redirect:/boards";
	}
	@PutMapping("/boards/{no}")
	public String update(@PathVariable("no") long no,BoardDTO dto) {
		service.updateProcess(no,dto);
		return"redirect:/boards/"+no;
	}
}
