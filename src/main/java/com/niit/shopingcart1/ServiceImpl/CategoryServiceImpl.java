package com.niit.shopingcart1.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopinngcart1.dao.CategoryDao;
import com.niit.shopinngcart1.model.Category;
import com.niit.shopinngcart1.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CategoryDao categorydao;
	


    @Transactional
	
	public void add(Category category) {
		categorydao.add(category);
    }
   
    
    @Transactional
	public void edit(Category category) {
		categorydao.edit(category);
		

	}
    @Transactional
	
	public void delete(int categoryid) {
		categorydao.delete(categoryid);

	}
    @Transactional

	public Category getsinglecategory(int categoryid) {
		return categorydao.getsinglecategory(categoryid);
	}
    @Transactional
	public List getAllCategorys() {
		return categorydao.getAllCategorys();
	
	}

}
