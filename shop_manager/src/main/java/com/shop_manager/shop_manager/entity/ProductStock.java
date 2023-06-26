package com.shop_manager.shop_manager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	@Column(unique=true)
	private String batchNumber;
//	private String manifacturedDate;
//	private String expireDate;
	String mfDate;
	String exDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	private Product prodStock;

	public ProductStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductStock(Long id, Integer quantity, String batchNumber, String mfDate, String exDate) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.batchNumber = batchNumber;
		this.mfDate = mfDate;
		this.exDate = exDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getMfDate() {
		return mfDate;
	}

	public void setMfDate(String mfDate) {
		this.mfDate = mfDate;
	}

	public String getExDate() {
		return exDate;
	}

	public void setExDate(String exDate) {
		this.exDate = exDate;
	}

	@Override
	public String toString() {
		return "ProductStock [id=" + id + ", quantity=" + quantity + ", batchNumber=" + batchNumber + ", mfDate="
				+ mfDate + ", exDate=" + exDate + "]";
	}

	
	
}
