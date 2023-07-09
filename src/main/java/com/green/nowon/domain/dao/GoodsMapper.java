package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;

@Mapper
public interface GoodsMapper {

	void save(GoodSaveDTO dto);

	void saveImg(S3UploadDTO img);

}
