package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.BoardDTO;

public interface BoardService {

	void saveProcess(BoardDTO dto);

	void findAllProcess(Model model);

	void detailProcess(long no, Model model);

}
