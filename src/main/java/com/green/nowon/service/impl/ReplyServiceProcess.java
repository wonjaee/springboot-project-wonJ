package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dao.ReplyMapper;
import com.green.nowon.domain.dto.ReplyDTO;
import com.green.nowon.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceProcess implements ReplyService{

	private final ReplyMapper mapper;
	
	
	//@Override
	//public void saveProcess(ReplyDTO dto) {
	//	mapper.save(dto);
		
	//}

}
