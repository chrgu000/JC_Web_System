package com.service.impl;

import com.bean.SysUsers;
import com.dao.SysUsersDAO;

public class ActionManagerImpl implements com.service.ActionManager {

	private SysUsersDAO sysUsersDAO;
	
	public SysUsersDAO getSysUsersDAO() {
		return this.sysUsersDAO;
	}
	
	public void setSysUsersDAO(SysUsersDAO userDAO) {
		this.sysUsersDAO = userDAO;
	}

	public Integer validLogin(String username, String password){
		
			 try {	
					SysUsers user = sysUsersDAO.findSysUsersByNameAndPass(username, password);
					if (user!= null)
					{
						return user.getUserId();
					}
		     }
		     catch (Exception e)
		     {
		            System.out.println(e.getMessage());
		     }
	         return null;
	}
}
