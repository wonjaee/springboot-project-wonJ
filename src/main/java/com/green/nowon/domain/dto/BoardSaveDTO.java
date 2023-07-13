package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class BoardSaveDTO {

	private long no;
	private String title;
	private String content;
	private int readCount;
	private String nickName;
	private LocalDateTime createdDate;//자동구성
	private LocalDateTime updatedDate;//자동구성
}
