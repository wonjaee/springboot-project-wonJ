package com.green.nowon.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.dto.MemberRole;
import com.green.nowon.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceProcess implements MemberService{
	
	private final MemberMapper mapper;
	
	private final PasswordEncoder encoder;
	
	@Override
	public void saveMember(MemberDTO dto) {//role 입력은 두번해야함
		System.out.println(">>>save전 no:"+dto.getMno());
		mapper.saveMember(dto.toEncoder(encoder));
		
		System.out.println(">>>save후 no:"+dto.getMno());
		mapper.saveRole(dto.getMno(),MemberRole.USER);
		//role테이블에 입력
		//long mno=dto.getNo();
		/*
		roleMapper.roleSave(MyuserDTO.builder()
				.mno(dto.getMno())
				.role(MemberRole.USER)
				.build());
	*/
	}


}
