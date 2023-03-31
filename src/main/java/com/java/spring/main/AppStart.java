package com.java.spring.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.spring.config.AppConfig;
import com.java.spring.entities.Product;
import com.java.spring.entities.Vendor;
import com.java.spring.services.ProductServiceImpl;
import com.java.spring.services.VendorServiceImpl;

public class AppStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(AppConfig.class);
		SessionFactory sfactory1 = (SessionFactory)context.getBean("factory");
		
		ProductServiceImpl service1 = (ProductServiceImpl)context.getBean("myservicep");
		System.out.println(service1.hashCode()+"productserviceimpl");
		System.out.println(service1.pdaoImpl.hashCode()+"productdaoimpl");
		
		System.out.println(service1.pdaoImpl.sfactory.hashCode()+"hashcode of product session factory");//having same hash code
		System.out.println(sfactory1.hashCode()+"hash code of localsessionfactory");
		//bcoz sessionfactory is a parent of local sessionfactory..
		
		
		System.out.println("---------------------------------------------");
		
        Vendor v1 = new Vendor(222, "amazon", new ArrayList<Product>());
		
		Product pd1 = new Product(101, "mobile", 28000, 2, "electronics", v1);
		Product pd2 = new Product(102, "pen", 300, 30, "stationary", v1);
		Product pd3 = new Product(103, "talcum powder", 3000, 30, "cosmetic", v1);
		Product pd4 = new Product(104, "pan", 3467, 12, "kitchen", v1);
		

		v1.getProdList().add(pd1);
		v1.getProdList().add(pd2);
		v1.getProdList().add(pd3);
		v1.getProdList().add(pd4);

		
	    VendorServiceImpl service2 = (VendorServiceImpl)context.getBean("myservicev");
		service2.addVendor(v1);
		
		
		
		System.out.println(service2.hashCode()+"vendor service impl hashcode");
		//System.out.println(service2.vDaoImpl.hashCode()+"vendor dao impl hashcode");
		
		
		//System.out.println(service2.vDaoImpl.sfactory.hashCode()+"hashcode for vendor session factory");
		System.out.println(sfactory1.hashCode()+"hash code of vendor local factory..");
		
				
		service1.addProduct(pd1);
     	service1.addProduct(pd2);
		service1.addProduct(pd3);
		service1.addProduct(pd4);
		
    	

	}

}
