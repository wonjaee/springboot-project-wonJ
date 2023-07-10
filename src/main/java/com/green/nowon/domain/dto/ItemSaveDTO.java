package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class ItemSaveDTO {
	private String title;
	private int price;
	private int stock;
	private String content;
}
