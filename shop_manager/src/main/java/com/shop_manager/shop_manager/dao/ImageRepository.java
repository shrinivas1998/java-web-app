package com.shop_manager.shop_manager.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop_manager.shop_manager.entity.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);

	Optional<ImageModel> findByProdId(long imageName);
}