package com.green.nowon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dao.RoleMapper;
import com.green.nowon.domain.dto.MemberDTO;

@SpringBootTest
class SpringbootProjectWonjaeApplicationTests {
	
	@Autowired
	private  MemberMapper mapper;
	@Autowired
	private  RoleMapper roleMapper;
	@Autowired
	private  PasswordEncoder encoder;
	
	//@Test
	void admin계정생성(MemberDTO dto) {
	
		

}
}
