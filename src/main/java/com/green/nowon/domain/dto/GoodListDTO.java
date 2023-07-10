package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class GoodListDTO {
	private String bucketKey;
	
	private String defImg;
	
	public GoodListDTO defImg(String domain) {
		defImg=domain+bucketKey;
		return this;
	}
	
	private long no;
	private String title;
	private int price;
	private int stock;
}
