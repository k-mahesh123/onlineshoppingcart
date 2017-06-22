package com.niit.shopinngcart1.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shopinngcart1.model.Category;
@Component
public interface CategoryService {
	public void add(Category category);
	public void edit(Category category);
	public void delete(int categoryid);
	public Category getsinglecategory(int categoryid);
	public List getAllCategorys();

}
