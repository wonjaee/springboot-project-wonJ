package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class GoodsImgListDTO {

	private String bucketKey;
	private boolean def;
	private String url;
	
	public GoodsImgListDTO url(String domain) {
		url=domain+bucketKey;
		return this;
	}
}
