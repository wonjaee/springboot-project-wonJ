package com.green.nowon.service.impl;




import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.MemberService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceProcess implements MemberService{
	
	private final MemberMapper mapper;
	
	@Override
	public void memberSave(MemberDTO dto) {
		
		mapper.memberSave(dto);
		
	}


}
