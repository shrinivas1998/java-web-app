package com.shop_manager.shop_manager.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ShopReg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String shopName;
	String businessCatogory;
	String gstnNumber;
	boolean  gstCompansation;
	String address;
	Integer phoneNumber;
	String emailId;
	@OneToMany(targetEntity = Product.class, cascade =CascadeType.ALL)
	@JoinColumn(name = "shopFk",referencedColumnName = "id")
	private Set<Product> products;
	
	public ShopReg(Long id, String shopName, String businessCatogory, String gstnNumber, boolean gstCompansation,
			String address, Integer phoneNumber, String emailId) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.businessCatogory = businessCatogory;
		this.gstnNumber = gstnNumber;
		this.gstCompansation = gstCompansation;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public ShopReg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBusinessCatogory() {
		return businessCatogory;
	}
	public void setBusinessCatogory(String businessCatogory) {
		this.businessCatogory = businessCatogory;
	}
	public String getGstnNumber() {
		return gstnNumber;
	}
	public void setGstnNumber(String gstnNumber) {
		this.gstnNumber = gstnNumber;
	}
	public boolean isGstCompansation() {
		return gstCompansation;
	}
	public void setGstCompansation(boolean gstCompansation) {
		this.gstCompansation = gstCompansation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "ShopReg [id=" + id + ", shopName=" + shopName + ", businessCatogory=" + businessCatogory
				+ ", gstnNumber=" + gstnNumber + ", gstCompansation=" + gstCompansation + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", products=" + products + "]";
	}
	
}
