package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private long no;
	private String title;
	private String content;
	private int readCount;
	private String writer;
	private LocalDateTime createdDate;//자동구성
	private LocalDateTime updatedDate;//자동구성
}
