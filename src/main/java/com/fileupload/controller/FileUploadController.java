package com.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fileupload.service.FileUploadService;

@RestController
public class FileUploadController {
	
	@Autowired
	FileUploadService fileupload; 
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/upload")
	public String print() {
		fileupload.uploadFile();
		return "done";
	}

}
