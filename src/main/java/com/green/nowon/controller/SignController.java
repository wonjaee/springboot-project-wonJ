package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignController {
	
	private final MemberService service;
	
	//signin(로그인)페이지로 이동
	@GetMapping("/signin")
	public String signin() {
		return "sign/signin";
	}
	
	//signup(회원가입)페이지로 이동
	@GetMapping("/signup")
	public String signup() {
		return "sign/signup";
	}
	
	//회원가입후 로그인페이지로 이동
	@PostMapping("/signup")
	public String signup(MemberDTO dto) {
		service.memberSave(dto);
		return "redirect:/signin";
		
	}
}
