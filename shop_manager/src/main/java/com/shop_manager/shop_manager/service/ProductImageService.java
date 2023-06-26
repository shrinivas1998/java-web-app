package com.shop_manager.shop_manager.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.shop_manager.shop_manager.dao.ProductImageRepository;
import com.shop_manager.shop_manager.entity.ProductImage;

public class ProductImageService {
	
	@Autowired
    private ProductImageRepository imageRepo;
	
	public ProductImage uploadImage(MultipartFile file) throws IOException {
		ProductImage pImage = new ProductImage();
		pImage.setName(file.getOriginalFilename());
		pImage.setType(file.getContentType());
		pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
		System.out.println(pImage.getImageData());
		return imageRepo.save(pImage);
	}
	
	public byte[] downloadImage(String fileName){
        Optional<ProductImage> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}
