package com.green.nowon.service;

import com.green.nowon.domain.dto.MemberDTO;

public interface MemberService {

	void saveMember(MemberDTO dto);

	int idCheck(String id);

	

}
