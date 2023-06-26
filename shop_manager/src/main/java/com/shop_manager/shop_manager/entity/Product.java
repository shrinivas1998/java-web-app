package com.shop_manager.shop_manager.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pId;
	String productName;
	String productCategory;
	String productBrand;
	String productHsn;
	String type;
	BigDecimal productPrice;
	Long shopFk;
//	@Column(length = 10000)
//	private byte[] byteArray;
	
//	@Column(name = "picByte", length = 1000)
//	private byte[] picByte;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "prodStock")
	ProductStock pStock;
	
//	
//	
//	public Product(Long pId, String productName, String productCategory, String productBrand, String productHsn,
//			String type, BigDecimal productPrice, Long shopFk, byte[] byteArray, ProductStock pStock) {
//		super();
//		this.pId = pId;
//		this.productName = productName;
//		this.productCategory = productCategory;
//		this.productBrand = productBrand;
//		this.productHsn = productHsn;
//		this.type = type;
//		this.productPrice = productPrice;
//		this.shopFk = shopFk;
//		this.byteArray = byteArray;
//		this.pStock = pStock;
//	}
//	
//	public byte[] getByteArray() {
//		return byteArray;
//	}
//
//	public void setByteArray(byte[] bs) {
//		this.byteArray = bs;
//	}
//	
//	public byte[] getPicByte() {
//		return picByte;
//	}
//
//	public void setPicByte(byte[] picByte) {
//		this.picByte = picByte;
//	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getpId() {
		return pId;
	}
	
	
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	public Long getShopFk() {
		return shopFk;
	}
	public void setShopFk(Long shopFk) {
		this.shopFk = shopFk;
	}
	
	public String getProductHsn() {
		return productHsn;
	}
	public void setProductHsn(String productHsn) {
		this.productHsn = productHsn;
	}
	
		
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productBrand=" + productBrand + ", productHsn=" + productHsn + ", productPrice=" + productPrice
				+ ", shopFk=" + shopFk + "]";
	}
	
	
	
	
}
