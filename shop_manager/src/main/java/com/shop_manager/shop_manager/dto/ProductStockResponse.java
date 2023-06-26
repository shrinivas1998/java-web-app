package com.shop_manager.shop_manager.dto;

import java.math.BigDecimal;

public class ProductStockResponse {
	String productName;
	String productCategory;
	BigDecimal productPrice;
	String productBrand;
	Integer quantity;
	public ProductStockResponse(String productName, String productCategory, BigDecimal productPrice,
			String productBrand, Integer quantity) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productBrand = productBrand;
		this.quantity = quantity;
	}
	public ProductStockResponse() {
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
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductStockResponse [productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + ", productBrand=" + productBrand + ", quantity=" + quantity + "]";
	}
	
	
}
