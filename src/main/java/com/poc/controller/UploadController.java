package com.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poc.service.UploadService;

@RestController
@RequestMapping("/upload")
public class UploadController {
	private final UploadService uploadService; 
	@Autowired 
	public UploadController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@PostMapping
	public ResponseEntity<String> upload(@RequestParam MultipartFile file){
		if (file == null) {
			return ResponseEntity.badRequest().body("file not valid");
		}
		//now upload file to S3.
		if (uploadService.uploadFileToS3(file)) {
			return ResponseEntity.ok("File Name is : " +
					file.getOriginalFilename() + " file size is " + file.getSize() + " uploaded successfully");
		}
		return ResponseEntity.ok("File not uploaded");
		
	}
	
}
