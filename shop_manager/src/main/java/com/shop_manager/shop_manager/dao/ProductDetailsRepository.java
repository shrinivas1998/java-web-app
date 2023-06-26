package com.shop_manager.shop_manager.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop_manager.shop_manager.entity.Product;

@Repository
public interface ProductDetailsRepository extends JpaRepository<Product, Integer>{

	@Query("select productName from Product where shopFk=:shopFk and productName like :pName")
	public List<String> searchByProductName(@Param("pName") String pName,@Param("shopFk") Long shopFk);
	
	@Query("SELECT p.productName FROM ShopReg s JOIN s.products p where s.emailId=:emailId")
	public List<String> getProductNameList(@Param("emailId") String emailId);
	
	@Query("select pId from Product where productName=:pName")
	public long searchByProducIdByPName(@Param("pName") String pName);
	
	Optional<Product> findByProductName(String fileName);
	
}
