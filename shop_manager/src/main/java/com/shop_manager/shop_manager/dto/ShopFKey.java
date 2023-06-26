package com.shop_manager.shop_manager.dto;

public class ShopFKey {

	Long shopFk;
	
	public Long getShopFk() {
		return shopFk;
	}

	public void setShopFk(Long shopFk) {
		this.shopFk = shopFk;
	}
	
	
	public ShopFKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopFKey(Long shopFk) {
		super();
		this.shopFk = shopFk;
	}

	@Override
	public String toString() {
		return "ShopFKey [shopFk=" + shopFk + "]";
	}
	
}
