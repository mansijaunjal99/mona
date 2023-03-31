package com.java.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
	private int vendorId;
	private String vendorName;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "prodVendor")
	//@JoinColumn(name = "PRODUCT_ID_FK",unique = false,nullable = true)
	private List<Product>prodList;

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(int vendorId, String vendorName, List<Product> prodList) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.prodList = prodList;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<Product> getProdList() {
		return prodList;
	}

	public void setProdList(List<Product> prodList) {
		this.prodList = prodList;
	}

	@Override
	public String toString() {
		return "\nVendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", prodList=" + prodList + "]";
	}
	
	
	
	
	

}
