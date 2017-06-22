package com.niit.shopinngcart1.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopinngcart1.dao.UserDao;
import com.niit.shopinngcart1.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    public SessionFactory sessionFactory;
				
    public UserDaoImpl(SessionFactory sessionfactory)
    {
		this.sessionFactory=sessionFactory;
	}
    @Transactional
    public boolean  validate(String username, String password)

	{
		String hql = " from User where username='" + username + "'and password='" + password + "'";
		
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

	public boolean update(User usr) {
		try {
			sessionFactory.getCurrentSession().update(usr);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

@Transactional
@Override
public User get(String id) {
	return (User) sessionFactory.getCurrentSession().get(User.class,id);
}


@Transactional
public boolean save(User usr) {
	System.out.println(usr);
	try 
	{
		sessionFactory.getCurrentSession().save(usr);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return false;
	}
	return true;
}
@Override
public List<User> list() {
	// TODO Auto-generated method stub
	return null;
}
@Transactional
public List getAllUsers() {
	
	List list = (List)sessionFactory.getCurrentSession().createQuery("from User").list();
	return list;

}

}
	



