package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.GoodsMapper;
import com.green.nowon.domain.dto.GoodListDTO;
import com.green.nowon.domain.dto.GoodSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;
import com.green.nowon.service.FileUploadService;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodsServiceProcess implements GoodsService{

	private final GoodsMapper goodsMapper;
	private final FileUploadService fileService;
	
	@Value("${cloud.aws.s3.domain}")
	private String domain;
	
	@Override
	public void save(GoodSaveDTO dto) {
		goodsMapper.save(dto);
		System.out.println(dto);
		dto.files().forEach(img->{
			System.out.println(img);
			S3UploadDTO uploadResult = fileService.tempToUpload(img);
			goodsMapper.saveImg(uploadResult.gno(dto.getNo()));
		});
	}

	@Override
	public void listProcess(Model model) {
		List<GoodListDTO> result=goodsMapper.findAll().stream()
				.map(dto->dto.defImg(domain))
				.collect(Collectors.toList());
		
		model.addAttribute("list", result);
		
		result.forEach(dto->{
			System.out.println(dto);
		});
		
	}

	
}
