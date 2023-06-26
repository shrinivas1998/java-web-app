package com.shop_manager.shop_manager.dto;

import java.math.BigDecimal;

public class ProductList {
	
	String productName;
	String productCategory;
	String productBrand;
	String productHsn;
	BigDecimal productPrice;
	
	public ProductList(String productName, String productCategory, String productBrand, String productHsn,
			BigDecimal productPrice) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productHsn = productHsn;
		this.productPrice = productPrice;
	}
	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductHsn() {
		return productHsn;
	}
	public void setProductHsn(String productHsn) {
		this.productHsn = productHsn;
	}
	@Override
	public String toString() {
		return "ProductList [productName=" + productName + ", productCategory=" + productCategory + ", productBrand="
				+ productBrand + ", productHsn=" + productHsn + ", productPrice=" + productPrice + "]";
	}
	
	
}
