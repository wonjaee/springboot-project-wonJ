package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class GoodsDetailDTO {
	private long no;
	private String title;
	private String content;
	private int price;
	private int stock;
}
