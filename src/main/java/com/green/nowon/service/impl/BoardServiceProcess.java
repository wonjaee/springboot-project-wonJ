package com.green.nowon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.BoardMapper;
import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceProcess implements BoardService{
	
	private final BoardMapper boardmapper;
	
	@Override
	public void saveProcess(BoardDTO dto) {
		boardmapper.saveAll(dto);
		
	}

	@Override
	public void findAllProcess(Model model) {
		List<BoardDTO> result= boardmapper.findAll();
		model.addAttribute("list",result);
		
	}

	@Override
	public void detailProcess(long no, Model model) {
		model.addAttribute("detail",boardmapper.findByNo(no).orElseThrow());
		
	}

}
