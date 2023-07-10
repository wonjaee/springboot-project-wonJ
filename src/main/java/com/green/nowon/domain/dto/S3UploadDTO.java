package com.green.nowon.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class S3UploadDTO {
	
	private String tempKey;
	private String bucketKey;
	private String orgName;
	private String newName;
	private boolean def;
	private long gno; //fk 상품pk
	
	public S3UploadDTO gno(long no) {
		gno=no;
		return this;
	}
	
	public S3UploadDTO bucketKey(String bucketKey) {
		this.bucketKey=bucketKey;
		return this;
	}
}

