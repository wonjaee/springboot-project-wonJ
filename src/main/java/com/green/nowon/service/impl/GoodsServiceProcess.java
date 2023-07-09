package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.GoodsMapper;
import com.green.nowon.domain.dto.GoodSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodsServiceProcess implements GoodsService{

	private final GoodsMapper goodsMapper;
	private final FileUploadServiceProcess fileService;
	
	@Override
	public void save(GoodSaveDTO dto) {
		goodsMapper.save(dto);
		dto.files().forEach(img->{
			S3UploadDTO uploadResult = fileService.tempToUpload(img);
			goodsMapper.saveImg(uploadResult.gno(dto.getNo()));
		});
	}

	
}
