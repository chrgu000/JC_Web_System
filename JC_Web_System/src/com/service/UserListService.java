package com.service;

import java.util.List;

import com.bean.SysUsers;
import com.dao.SysUsersDAO;

public interface UserListService {

	public SysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(SysUsersDAO userDAO);
	public List<SysUsers> getAllUsers();
	public SysUsers getUserByID(int userID);
}
