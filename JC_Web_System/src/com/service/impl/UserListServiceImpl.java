package com.service.impl;

import java.util.List;

import com.bean.SysUsers;
import com.dao.SysUsersDAO;

public class UserListServiceImpl implements com.service.UserListService {

	private SysUsersDAO sysUsersDAO;
	
	public SysUsersDAO getSysUsersDAO() {
		return this.sysUsersDAO;
	}
	
	public void setSysUsersDAO(SysUsersDAO userDAO) {
		this.sysUsersDAO = userDAO;
	}

	//获取所有用户
	public List<SysUsers> getAllUsers() {
		 try {	
				List<SysUsers> AllUsers = sysUsersDAO.findAll();
				if (AllUsers!= null)
				{
					return AllUsers;
				}
	     }
	     catch (Exception e)
	     {
	            System.out.println(e.getMessage());
	     }
      return null;
	}

	public SysUsers getUserByID(int userID) {
		try {
			SysUsers User = sysUsersDAO.get(userID);
			if (User != null) {
				return User;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<SysUsers> getUsersByT_N(int userType, String userName) {
		try {
			List<SysUsers> AllUsers = sysUsersDAO.getByT_N(userType,userName);
			if (AllUsers != null) {
				return AllUsers;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
