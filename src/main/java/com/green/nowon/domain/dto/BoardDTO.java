package com.green.nowon.domain.dto;

import java.time.LocalDateTime;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private long no;
	private String title;
	private String content;
	private int readCount;
	private String nickName=currentUserName();
	private LocalDateTime createdDate;//자동구성
	private LocalDateTime updatedDate;//자동구성
	
	public String currentUserName() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		return user.getUsername();
	}
}
