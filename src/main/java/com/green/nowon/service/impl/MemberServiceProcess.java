package com.green.nowon.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dao.RoleMapper;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.dto.MyuserDTO;
import com.green.nowon.security.MyRole;
import com.green.nowon.service.MemberService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceProcess implements MemberService{
	
	private final MemberMapper mapper;
	private final RoleMapper roleMapper;
	private final PasswordEncoder encoder;
	
	@Override
	public void memberSave(MemberDTO dto) {//role 입력은 두번해야함
		System.out.println(">>>save전 no:"+dto.getNo());
		mapper.memberSave(dto.toEncoder(encoder));
		
		System.out.println(">>>save후 no:"+dto.getNo());
		
		//role테이블에 입력
		//long mno=dto.getNo();
		
		roleMapper.roleSave(MyuserDTO.builder()
				.mno(dto.getNo())
				.role(MyRole.USER)
				.build());
	}
}
