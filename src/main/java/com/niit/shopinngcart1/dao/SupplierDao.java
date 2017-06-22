package com.niit.shopinngcart1.dao;

import java.util.List;

import com.niit.shopinngcart1.model.Supplier;



public interface SupplierDao {

	
	
	public void save(Supplier supplier);
	public List getAllSuppliers() ;
	
	public Supplier getSingleSupplier(int id);
	public void delete(int id);
	public void update(Supplier supplier);
	
	

}
