package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestBoardController {

	@GetMapping("/rest-boards")
	public String board() {
		return"board/rest-list";
	}
}
