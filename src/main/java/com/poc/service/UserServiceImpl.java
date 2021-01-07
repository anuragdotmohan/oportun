package com.poc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UploadService{

	@Override
	public boolean uploadFileToS3(MultipartFile file) {
		// TODO Auto-generated method stub
		// use AWS SDK to upload file to S3
		return true;
	}

}
