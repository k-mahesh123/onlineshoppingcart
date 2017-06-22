package com.niit.shopinngcart1.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shopinngcart1.model.CartItem;
import com.niit.shopinngcart1.model.Category;
@Component
public interface CartDao {
	public void add(CartItem cartItem);
	public void update(CartItem cartItem);
	public List getAllItems(String username);
	public List getAllItems();
	public void delete(int id);
	public void removeAll(String udername);
	public CartItem getsinglecartitem(int id);
	

}
