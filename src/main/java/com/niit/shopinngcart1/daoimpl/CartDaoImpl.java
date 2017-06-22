package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.CartDao;
import com.niit.shopinngcart1.model.CartItem;
import com.niit.shopinngcart1.model.Category;
@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public void add(CartItem cartItem) 
	{
		 sessionFactory.getCurrentSession().save(cartItem);
		//session.saveOrUpdate(item);
//		Session session=sessionFactory.openSession();
//		org.hibernate.Transaction tx=session.beginTransaction();
//		session.saveOrUpdate(cartItem);
//		tx.commit();
	}

	
	@Override
	@Transactional
	public List getAllItems()
	{
       
        return  sessionFactory.getCurrentSession().createQuery("from CartItem").list();
	
	}
	@Override
	@Transactional
	public void delete(int id)
	{
		
		sessionFactory.getCurrentSession().delete(getsinglecartitem(id));		
	}
	@Override
	@Transactional
	public void removeAll(String username) 
	{
		List<CartItem> cartItems = getAllItems(username);
		for(CartItem item: cartItems) 
		{
			delete(item.cartItemId);
		}
		
	}
	@Override
	@Transactional
	public List getAllItems(String username) {
		String hql = "from CartItem where username=" + "'"+ username+"'";
		
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	@Transactional
	public void update(CartItem cartItem) {
		 sessionFactory.getCurrentSession().update(cartItem);
		
	}
	@Override
	@Transactional
	public CartItem getsinglecartitem(int id) {
		// TODO Auto-generated method stub
	 return (CartItem) sessionFactory.getCurrentSession().get(CartItem.class, id);
	}
	
}
