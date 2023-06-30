package com.green.nowon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dao.RoleMapper;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.dto.MemberRole;

@SpringBootTest
class SpringbootProjectWonjaeApplicationTests {
	
	@Autowired
	private  MemberMapper memberMapper;
	@Autowired
	private  PasswordEncoder encoder;
	
	@Commit
	@Transactional
	@Test
	void 회원가입() {
		MemberDTO dto=new MemberDTO();
		dto.setId("admin");
		dto.setEmail("test1@test.com");
		dto.setPassword(encoder.encode("1234"));
		dto.setName("테스트1");
		memberMapper.saveMember(dto);
		memberMapper.saveRole(dto.getMno(),MemberRole.ADMIN);
	}

}

