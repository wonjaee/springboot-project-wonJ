package com.green.nowon.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.green.nowon.service.FileUploadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadServiceProcess implements FileUploadService{
	
	private final AmazonS3Client client;
	@Override
	public Map<String, String> tempUploadProcess(MultipartFile temp) {
		
		Map<String, String> resultMap=new HashMap<>();
		return resultMap;
	}

}
