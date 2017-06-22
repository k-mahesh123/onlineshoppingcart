package com.niit.shopinngcart1.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shopinngcart1.model.Product;
@Component
public interface ProductService {
	public void add(Product product);
	public void edit(Product product);
	public void delete(int productid);
	public Product getsingleproduct(int productid);
	public List getAllProducts();
}
