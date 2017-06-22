package com.niit.shopinngcart1.dao;

import java.util.List;

import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.model.UserSignUP;





public interface UserSignUPDao {

	public List<UserSignUP> list();
	public UserSignUP get(String username);
	
	public List getAllUsers();
	public boolean save(UserSignUP user2);
	public UserSignUP getSingleuser(String username);
	public boolean update(UserSignUP user);
	public boolean validate(String username,String password);
	
	
	
	
}
