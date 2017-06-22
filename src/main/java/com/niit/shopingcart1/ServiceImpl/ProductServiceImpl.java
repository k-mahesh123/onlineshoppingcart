package com.niit.shopingcart1.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopinngcart1.dao.ProductDao;
import com.niit.shopinngcart1.model.Product;
import com.niit.shopinngcart1.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	ProductDao productdao;


    @Transactional
	
	public void add(Product product) {
    	productdao.add(product);

	}
    @Transactional
	public void edit(Product product) {
	productdao.edit(product);
		

	}
    @Transactional
	
	public void delete(int productid) {
    	productdao.delete(productid);

	}
    @Transactional

	public Product getsingleproduct(int productid) {
    	return productdao.getsingleproduct(productid);
	}
    @Transactional
	
	public List getAllProducts() {
    	return productdao.getAllProducts();
	
	}


}
