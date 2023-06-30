package com.green.nowon.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dto.MemberDTO;


@Component
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		
		MemberDTO result = mapper.findById(id).orElseThrow(()-> new UsernameNotFoundException("존재하지않아요"));
		System.out.println(">>"+result);
		Set<SimpleGrantedAuthority> grantedAuthority=result.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role.roleName())) 
				.collect(Collectors.toSet());
		System.out.println("role 테이블을 읽어옵니다.");
		return new User(result.getId(), result.getPassword(), grantedAuthority);
	}

}
