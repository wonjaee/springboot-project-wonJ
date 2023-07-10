package com.green.nowon.domain.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodListDTO;
import com.green.nowon.domain.dto.GoodSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;

@Mapper
public interface GoodsMapper {

	void save(GoodSaveDTO dto);

	void saveImg(S3UploadDTO img);

	List<GoodListDTO> findAll();

}
