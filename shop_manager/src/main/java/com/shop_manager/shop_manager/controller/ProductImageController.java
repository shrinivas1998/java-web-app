package com.shop_manager.shop_manager.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shop_manager.shop_manager.service.ProductImageService;



@RestController
public class ProductImageController {
	
	private ProductImageService productImageService = new ProductImageService();
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("productImage")MultipartFile file) throws IOException{
		productImageService.uploadImage(file);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
		byte[] image = productImageService.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK).body(image);
	}
}
