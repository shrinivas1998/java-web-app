package com.shop_manager.shop_manager.dto;

public class ProductIdResoponse {
	private Integer quantity;

	public ProductIdResoponse(Integer quantity) {
		super();
		this.quantity = quantity;
	}

	public ProductIdResoponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductIdResoponse [quantity=" + quantity + "]";
	}
	
}
