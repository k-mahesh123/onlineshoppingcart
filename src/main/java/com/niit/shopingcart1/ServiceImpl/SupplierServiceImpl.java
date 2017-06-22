package com.niit.shopingcart1.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.service.SupplierService;
@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
  @Autowired
  SupplierDao  supplierdao;
	
	public void save(Supplier supplier) {
		 supplierdao.save(supplier);
	
	}

	@Override
	public List getAllSuppliers() {
		
		return supplierdao.getAllSuppliers();
	}

	@Override
	public Supplier getSingleSupplier(int id) {
		
		return supplierdao.getSingleSupplier(id);
	}

	@Override
	public void delete(int id) {
		supplierdao.delete(id);
		
	}

	@Override
	public void update(Supplier supplier) {
		supplierdao.update(supplier);
		
	}

}
