package com.java.spring.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.java.spring.entities.Product;
import com.java.spring.entities.Vendor;
@Configuration("cfbean")
@ComponentScan(basePackages = {"com.java.spring.*"})
public class AppConfig {
	
	@Bean("ds")
	public BasicDataSource dataBaseSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost/sp_db");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}
	
	
	@Bean("factory")
	public LocalSessionFactoryBean localSBean() {
		LocalSessionFactoryBean lfactory = new LocalSessionFactoryBean();
		lfactory.setDataSource(dataBaseSource());
		//lfactory.setPackagesToScan("com.java.spring.entities");
		lfactory.setAnnotatedClasses(Vendor.class,Product.class);
		
		Properties prop = new Properties();
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		prop.put(Environment.HBM2DDL_AUTO, "create");
		prop.put(Environment.SHOW_SQL, "true");
		lfactory.setHibernateProperties(prop);
		return lfactory;
		
	}

}
