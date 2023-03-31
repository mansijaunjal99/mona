package com.java.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.daos.ProductDaoImpl;
import com.java.spring.entities.Product;
@Service("myservicep")
public class ProductServiceImpl implements ProductService {
	@Autowired
	 public  ProductDaoImpl pdaoImpl;
	   

	public String addProduct(Product prod) {
		// TODO Auto-generated method stub
		if(prod==null) {
			System.out.println("Invalid product...cannot be null");
			return "Invalid Product..";
		}else {
			pdaoImpl.insertProduct(prod);
		}
		return null;
	}

}
