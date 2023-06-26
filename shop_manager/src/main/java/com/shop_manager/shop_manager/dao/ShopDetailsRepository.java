package com.shop_manager.shop_manager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop_manager.shop_manager.dto.ProductList;
import com.shop_manager.shop_manager.entity.ShopReg;
@Repository
public interface ShopDetailsRepository extends JpaRepository<ShopReg, Long>{
	
	
	@Query("SELECT new com.shop_manager.shop_manager.dto.ProductList(p.productName, p.productCategory, p.productBrand,  p.productHsn, p.productPrice) FROM ShopReg s JOIN s.products p where p.shopFk=:id")
	public List<ProductList> getJoinInformation(@Param("id") Long id);
	
	@Query("SELECT new com.shop_manager.shop_manager.dto.ProductList(p.productName, p.productCategory, p.productBrand, p.productHsn , p.productPrice) FROM ShopReg s JOIN s.products p where s.emailId=:emailId")
	public List<ProductList> getJoinInformationForEmail(@Param("emailId") String emailId);
	
	@Query("SELECT s.id FROM ShopReg s where s.emailId=:emailId")
	public Long getShopFk(@Param("emailId") String emailId);
	
	
	
}
