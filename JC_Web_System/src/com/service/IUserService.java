package com.service;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.dao.ISysUsersDAO;

public interface IUserService {

	SysUsers validLogin(String username , String password);
	public ISysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(ISysUsersDAO userDAO);
	SysUsers getUserByID(Integer userId);
	PageBean queryForPage(int pageCurrent);
	
}
