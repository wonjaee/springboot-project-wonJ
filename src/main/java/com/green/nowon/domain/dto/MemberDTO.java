package com.green.nowon.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDTO {

	private String id;
	private String password;
	private String email;
	private String name;
	private int birth;
	private String phone;
}
