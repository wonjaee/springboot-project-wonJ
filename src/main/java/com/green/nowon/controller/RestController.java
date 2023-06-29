package com.green.nowon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.ReplyDTO;
import com.green.nowon.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RestController {
	
	private final ReplyService service;
	
	@ResponseBody
	@PostMapping("/boards/{boardNo}/replies")
	public ResponseEntity<Boolean> save(ReplyDTO dto){
	service.saveProcess(dto);
	return ResponseEntity.ok().body(true);
	}
}
