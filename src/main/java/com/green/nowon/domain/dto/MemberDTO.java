package com.green.nowon.domain.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberDTO {

	private long mno;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	
	
	private Set<MemberRole> roles=new HashSet<>();
	
	
	public MemberDTO addRole(MemberRole myRole) {
		roles.add(myRole);
		return this;
	}

	public MemberDTO toEncoder(PasswordEncoder encoder) {
		password=encoder.encode(password);
		return this;
	}
}
