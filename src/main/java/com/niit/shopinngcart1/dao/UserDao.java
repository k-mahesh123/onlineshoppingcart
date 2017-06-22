package com.niit.shopinngcart1.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shopinngcart1.model.User;
@Component
public interface UserDao {
	public List<User> list();
	public User get(String username);
	
	public List getAllUsers();
	public boolean save(User usr);
	
	public boolean update(User user);
	public boolean validate(String username,String password);

}
