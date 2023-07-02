package com.green.nowon.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemSaveDTO {
	
	private String title;
	private int price;
	private int stock;
	private String content;
}
