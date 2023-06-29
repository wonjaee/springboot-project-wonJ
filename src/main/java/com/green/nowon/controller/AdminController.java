package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	//admin default 페이지로 이동
	@GetMapping("/admin")
	public String adminIndex() {
		return "admin/default";
	}
	//admin 상품리스트 페이지로 이동
	@GetMapping("/admin/item")
	public String adminItem() {
		return"admin/item/list";
	}
	
	//admin 상품등록 페이지로 이동
	@GetMapping("/admin/item/new")
	public String adminItemNew() {
		return "admin/item/write";
	}
}
