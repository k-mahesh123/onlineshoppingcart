package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
   
	@Override
	public void add(Product product) {
		sessionFactory.getCurrentSession().save( product);

	}
   
	@Override
	public void edit(Product product) {
		sessionFactory.getCurrentSession().update( product);
		

	}
   
	@Override
	public void delete(int productid) {
		sessionFactory.getCurrentSession().delete(getsingleproduct(productid));

	}
  
	@Override
	public Product getsingleproduct(int productid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}
   
	@Override
	public List getAllProducts() {
		return (List)sessionFactory.getCurrentSession().createQuery("from Product").list();
	
	}

}
