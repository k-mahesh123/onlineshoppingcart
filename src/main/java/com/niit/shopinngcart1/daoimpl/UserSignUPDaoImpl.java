package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.UserSignUPDao;
import com.niit.shopinngcart1.model.Supplier;
import com.niit.shopinngcart1.model.UserSignUP;






@Repository("userSignUPDao")
public class UserSignUPDaoImpl implements UserSignUPDao {

	
	@Autowired
    public SessionFactory sessionFactory;
				
    public UserSignUPDaoImpl(SessionFactory sessionfactory)
    {
		this.sessionFactory=sessionFactory;
	}
    @Transactional
    public boolean  validate(String username, String password)

	{
		String hql = " from UserSignUP where username='" + username + "'and password='" + password + "'";
		
		if( sessionFactory.getCurrentSession().createQuery(hql).uniqueResult()!=null)
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	@Transactional

	public boolean update(UserSignUP user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

@Transactional
@Override
public UserSignUP get(String id) {
	return (UserSignUP) sessionFactory.getCurrentSession().get(UserSignUP.class,id);
}


@Transactional
public boolean save(UserSignUP user2) {
	System.out.println(user2);
	try 
	{
		sessionFactory.getCurrentSession().save(user2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return false;
	}
	return true;
}
@Override
public List<UserSignUP> list() {
	// TODO Auto-generated method stub
	return null;
}
@Transactional
public List getAllUsers() {
	
	List list = (List)sessionFactory.getCurrentSession().createQuery("from UserSignUP").list();
	return list;

}
@Transactional

@Override
public UserSignUP getSingleuser(String username) {

	

	return (UserSignUP) sessionFactory.getCurrentSession().load(UserSignUP.class, username);
}


}
	



