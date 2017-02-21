package com.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.dao.ISysUsersDAO;

public class UserServiceImpl implements com.service.IUserService {

	
	public static final int pageShowSize=5;
	
	private ISysUsersDAO sysUsersDAO;
	
	public ISysUsersDAO getSysUsersDAO() {
		return this.sysUsersDAO;
	}
	
	public void setSysUsersDAO(ISysUsersDAO userDAO) {
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

	public SysUsers getUserByID(Integer userId) {
		// TODO Auto-generated method stub
		try {
			SysUsers User = sysUsersDAO.get(userId);
			if (User != null) {
				return User;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public PageBean queryForPage(int pageCurrent) {
		HashMap conditionList=new HashMap<String, String>();
		
		HttpServletRequest request= ServletActionContext.getRequest();
		int userType=(Integer)
				(request.getSession().getAttribute("userType")
						==null?-1:request.getSession().getAttribute("userType"));
		
		String userName=(String) 
				(request.getSession().getAttribute("userName")
						==null?"":request.getSession().getAttribute("userName"));
		if(userType!=-1){
			conditionList.put("user_type=", userType);
		}
		if(userName!=""){
			conditionList.put("user_name like", "%"+userName+"%");
		}
	
		PageBean pb = sysUsersDAO.getByPage(conditionList,pageCurrent);
		

		return pb;

	}
}
