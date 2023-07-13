package com.green.nowon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.green.nowon.domain.dao.BoardMapper;
import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dao.RoleMapper;
import com.green.nowon.domain.dto.BoardDTO;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.domain.dto.MemberRole;

@SpringBootTest
class SpringbootProjectWonjaeApplicationTests {
	
	@Autowired
	private  MemberMapper memberMapper;
	@Autowired
	private  PasswordEncoder encoder;
	@Autowired
	private BoardMapper boardmapper;
	
	@Commit
	@Transactional
	@Test
	void 회원가입() {
		MemberDTO dto=new MemberDTO();
		dto.setId("admin");
		dto.setEmail("test1@test.com");
		dto.setPassword(encoder.encode("1234"));
		dto.setName("테스트1");
		dto.setPhone("12345");
		memberMapper.saveMember(dto);
		memberMapper.saveRole(dto.getMno(),MemberRole.ADMIN);
	}
	
	@Commit
	@Transactional
	//@Test
	void 내용삽입() {
		for(int i=1; i<100; i++) {
			BoardDTO dto=new BoardDTO();
			dto.setTitle("제목테스트"+i);
			dto.setContent("내용테스트"+i);
			boardmapper.saveAll(dto);
		}
	}

}

