package com.green.nowon.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.service.FileUploadService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GoodsController {
	
	private final FileUploadService fileService;
	
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
	@ResponseBody
	@PostMapping("/admin/goods/temp-img")
	public Map<String, String> tempUpload(MultipartFile temp){
		
		return fileService.tempUploadProcess(temp);
	}
}