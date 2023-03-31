package com.java.spring.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.entities.Vendor;
@Repository("repov")
public class VendorDaoImpl implements VendorDao {
	 @Autowired
	public SessionFactory sfactory;

	public String insertVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(vendor);
			return "Vendor Saved..!";
		}catch (Exception e) {
			return "Problem in Save";
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
