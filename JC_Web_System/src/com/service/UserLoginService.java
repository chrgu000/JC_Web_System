package com.service;

import com.dao.SysUsersDAO;

public interface UserLoginService {

	Integer validLogin(String username , String password);
	public SysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(SysUsersDAO userDAO);
	
}
