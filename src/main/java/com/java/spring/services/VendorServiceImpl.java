package com.java.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.daos.VendorDaoImpl;
import com.java.spring.entities.Vendor;
@Service("myservicev")
public class VendorServiceImpl implements VendorService {
	@Autowired
	public VendorDaoImpl vDaoImpl;

	public String addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vDaoImpl.insertVendor(vendor);
	}

}
