package com.bway.springmvc.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springmvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Resource
	
	private SessionFactory sessionFactory; // hibernet bin / object

	@Override
	@Transactional
	public void signup(User user) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		sess.save(user);
		
	}

	@Override
	@Transactional
	public User login(String un, String psw) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(User.class);
		
		crt.add(Restrictions.eq("username",un));
		
		crt.add(Restrictions.eq("password", psw));
		
		
		return (User) crt.uniqueResult();
	}
	
	
	
	

}
