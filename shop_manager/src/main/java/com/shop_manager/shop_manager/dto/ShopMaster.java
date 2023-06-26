package com.shop_manager.shop_manager.dto;

import com.shop_manager.shop_manager.entity.ShopReg;

public class ShopMaster {
	
	private ShopReg shopReg;

	public ShopMaster(ShopReg shopReg) {
		super();
		this.shopReg = shopReg;
	}

	public ShopMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopReg getShopReg() {
		return shopReg;
	}

	public void setShopReg(ShopReg shopReg) {
		this.shopReg = shopReg;
	}

	@Override
	public String toString() {
		return "ShopResponse [shopReg=" + shopReg + "]";
	}
	
	
}
