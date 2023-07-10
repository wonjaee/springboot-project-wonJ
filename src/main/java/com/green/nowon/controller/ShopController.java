package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {
	
	private final GoodsService service;
	
	//index->shop->man 으로 이동
	@GetMapping("/man")
	public String manList(Model model) {
		service.listProcess(model);
		return "shop/man";
	}
	
	@GetMapping("/goods/{goodsNo}")
	public String detail(@PathVariable long goodsNo,Model model) {
		service.detailProcess(goodsNo,model);
		return"shop/detail";
	}
}
