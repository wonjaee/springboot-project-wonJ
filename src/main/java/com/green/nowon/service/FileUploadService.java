package com.green.nowon.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	Map<String, String> tempUploadProcess(MultipartFile temp);

}
