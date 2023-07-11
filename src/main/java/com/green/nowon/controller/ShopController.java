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
	
	//index->shop->man페이지로 이동
	@GetMapping("/man")
	public String manList(Model model) {
		service.listProcess(model);
		return "shop/man";
	}
	@GetMapping("/man2")
	public String manList2(Model model) {
		service.listProcess(model);
		return "shop/man2";
	}
	//index -> 사진 상세정보페이지로 이동
	@GetMapping("/goods/{goodsNo}")
	public String detail(@PathVariable long goodsNo,Model model) {
		service.detailProcess(goodsNo,model);
		return"shop/detail";
	}

	
}
