package com.green.nowon.domain.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberDTO {

	private long no;
	private String id;
	private String password;
	private String email;
	private String name;
	private int birth;
	private String phone;
	
	private Set<MyRole> roles=new HashSet<>();
	
	public MemberDTO addRole(MyRole myRole) {
		roles.add(myRole);
		return this;
	}

	public MemberDTO toEncoder(PasswordEncoder encoder) {
		password=encoder.encode(password);
		return this;
	}
}
