package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodSaveDTO;

@Mapper
public interface GoodsMapper {

	void save(GoodSaveDTO dto);

}
