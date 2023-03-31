package com.java.spring.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.entities.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	public SessionFactory sfactory;

	public String insertProduct(Product prod) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(prod);
			return"Product saved";
		}catch(Exception ee) {
			return"Problem in product save opraration...";
			
		}finally {
			if(session!=null) {
				if(tr!=null) {
					session.flush();
					tr.commit();
				}
				session.close();
				
			}
			
			
		}
		
		
		
	}

}
