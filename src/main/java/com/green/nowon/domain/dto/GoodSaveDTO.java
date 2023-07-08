package com.green.nowon.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class GoodSaveDTO {
	private String title;
	private int price;
	private String content;
	private String tempkey;
	private String orgName;
	
	public List<S3UploadDTO> files(){
		List<S3UploadDTO> list= new ArrayList<>();
		list.add(S3UploadDTO.builder()
				.tempKey(tempkey)
				.orgName(orgName)
				.build());
		
		return list;
	}
}
