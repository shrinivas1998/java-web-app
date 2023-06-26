package com.shop_manager.shop_manager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop_manager.shop_manager.entity.ProductImage;


public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	
	Optional<ProductImage> findByName(String fileName);
}
