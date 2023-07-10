package com.green.nowon.domain.dto;

import java.util.ArrayList;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GoodSaveDTO {
	private long no;
	private String title;
	private int price;
	private String content;
	private String[] tempKey;
	private String[] orgName;
	private String[] newName;
	private boolean[] def;
	
	public List<S3UploadDTO> files(){
		List<S3UploadDTO> list=new ArrayList<>();
		for(int i=0; i<tempKey.length ;i++) {
			if(tempKey[i]!=null && tempKey[i]!="") {
				list.add(S3UploadDTO.builder()
						.tempKey(tempKey[i])
						.orgName(orgName[i])
						.newName(newName[i])
						.def(def[i])
						.build());
			}
		}
		
		return list;
	}
}