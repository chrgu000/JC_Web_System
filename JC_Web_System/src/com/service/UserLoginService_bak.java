package com.service;

import com.dao.ISysUsersDAO;

public interface UserLoginService_bak {

	Integer validLogin(String username , String password);
	public ISysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(ISysUsersDAO userDAO);
	
}
