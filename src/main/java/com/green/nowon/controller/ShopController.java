package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {
	private final GoodsService service;
	@GetMapping("/man")
	public String manList(Model model) {
		service.listProcess(model);
		return "shop/man";
	}
}
