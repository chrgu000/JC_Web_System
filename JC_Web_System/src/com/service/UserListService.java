package com.service;

import java.util.List;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.dao.ISysUsersDAO;

public interface UserListService {

	public ISysUsersDAO getSysUsersDAO();
	public void setSysUsersDAO(ISysUsersDAO userDAO);
	public List<SysUsers> getAllUsers();
	public SysUsers getUserByID(int userID);
	public List<SysUsers> getUsersByT_N(int userType, String userName);
	public void DeleteUserById(int userId);
	public int getPageCounts();
	public List<SysUsers> getByPage(int i);
	
	
	public PageBean queryForPage(int currentPage); 
}
