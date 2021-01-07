package com.poc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface UploadService {

	public boolean uploadFileToS3(MultipartFile file);
}
