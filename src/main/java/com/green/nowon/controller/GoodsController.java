package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	
	
	@ResponseBody
	@GetMapping("/admin/goods/new")
	public ModelAndView write() {
		return new ModelAndView("admin/goods/write");
	}
	
	@ResponseBody
	@GetMapping("/admin/goods")
	public ModelAndView list() {
		return new ModelAndView("admin/goods/list");
	}
}
