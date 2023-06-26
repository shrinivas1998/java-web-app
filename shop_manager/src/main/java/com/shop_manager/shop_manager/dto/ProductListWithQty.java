package com.shop_manager.shop_manager.dto;

import java.math.BigDecimal;

public class ProductListWithQty {
	String productName;
	String productCategory;
	String productBrand;
	BigDecimal productPrice;
	Integer quantity;
	public ProductListWithQty(String productName, String productCategory, String productBrand, BigDecimal productPrice,
			Integer quantity) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}
	public ProductListWithQty() {
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductListWithQty [productName=" + productName + ", productCategory=" + productCategory
				+ ", productBrand=" + productBrand + ", productPrice=" + productPrice + ", quantity=" + quantity + "]";
	}
	
}
