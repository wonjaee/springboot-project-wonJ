package com.green.nowon.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.green.nowon.domain.dto.ItemSaveDTO;
import com.green.nowon.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService service;
	
	//admin default 페이지로 이동
	@GetMapping("/admin")
	public String adminIndex() {
		return "admin/main";
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
	
	@PostMapping("/admin/item")
	public String adminItem(ItemSaveDTO itemDto) {
	service.saveProcess(itemDto);
		return "redirect:/admin/item";
	}
}
