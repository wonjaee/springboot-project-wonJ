package com.green.nowon.domain.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodListDTO;
import com.green.nowon.domain.dto.GoodSaveDTO;
import com.green.nowon.domain.dto.GoodsDetailDTO;
import com.green.nowon.domain.dto.GoodsImgListDTO;
import com.green.nowon.domain.dto.S3UploadDTO;

@Mapper
public interface GoodsMapper {

	void save(GoodSaveDTO dto);

	void saveImg(S3UploadDTO img);

	List<GoodListDTO> findAll();

	Optional<GoodsDetailDTO> detail(long goodsNo);

	List<GoodsImgListDTO> goodsImagesByDetailNo(long goodsNo);

}
