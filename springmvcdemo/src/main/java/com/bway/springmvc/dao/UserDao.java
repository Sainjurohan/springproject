package com.bway.springmvc.dao;

import com.bway.springmvc.model.User;

public interface UserDao {
	
	void signup(User user);
	
	
	User login (String un , String psw);
	

}
