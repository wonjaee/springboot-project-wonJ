package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodSaveDTO;

public interface GoodsService {

	void save(GoodSaveDTO dto);

	void listProcess(Model model);

}
