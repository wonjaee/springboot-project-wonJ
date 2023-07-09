package com.green.nowon.domain.dto;

import java.util.ArrayList;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class GoodSaveDTO {
	private long no;
	private String title;
	private int price;
	private String content;
	private String tempKey;
	private String orgName;
	
	public List<S3UploadDTO> files(){
		List<S3UploadDTO> list= new ArrayList<>();
		list.add(S3UploadDTO.builder()
				.tempKey(tempKey)
				.orgName(orgName)
				.build());
		
		return list;
	}
}
