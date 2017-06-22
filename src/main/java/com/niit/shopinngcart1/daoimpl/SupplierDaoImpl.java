package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Supplier;
@Component
@Repository
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
   
	@Override
	public void save(Supplier supplier) {
    
			sessionFactory.getCurrentSession().save(supplier);
		
	}
   
	@Override
	public List getAllSuppliers() {
			
			List list = (List)sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			return list;
		
	}


	
	@Override
	public Supplier getSingleSupplier(int supid) {
	
		Supplier supplier = (Supplier) sessionFactory.getCurrentSession().load(Supplier.class, supid);
	
		return supplier;
	}
	

	
	@Override
	public void delete(int supid) {
		
		
			
	
			sessionFactory.getCurrentSession().delete(getSingleSupplier(supid));

	
		
	}
	
	@Override
	public void update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		
	}




}