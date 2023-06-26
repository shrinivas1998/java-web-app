package com.shop_manager.shop_manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop_manager.shop_manager.entity.ProductStock;

public interface ProduStockRepository extends JpaRepository<ProductStock,Long>{

	@Query("SELECT quantity FROM ProductStock where pId=:Id")
	public Integer getInformationForQty(@Param("Id") Long id);
	
	
}
