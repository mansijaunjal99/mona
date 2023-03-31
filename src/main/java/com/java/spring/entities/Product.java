package com.java.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="product")
public class Product {
	@Id
	private int prodId;
	private String prodName;
	private double prodPrice;
	private int prodQty;
	private String prodCategory;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
     private Vendor prodVendor;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int prodId, String prodName, double prodPrice, int prodQty, String prodCategory, Vendor prodVendor) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQty = prodQty;
		this.prodCategory = prodCategory;
		this.prodVendor = prodVendor;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public Vendor getProdVendor() {
		return prodVendor;
	}

	public void setProdVendor(Vendor prodVendor) {
		this.prodVendor = prodVendor;
	}

	@Override
	public String toString() {
		return "\nProduct [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQty="
				+ prodQty + ", prodCategory=" + prodCategory + ", prodVendor=" + prodVendor + "]";
	}
     
     
     

}
