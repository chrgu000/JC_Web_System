package com.service.impl;

import java.util.List;

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
		PageBean pb=new PageBean();
			pb.init();
			pb.setCurrentPage(PageBean.countCurrentPage(pageCurrent));
			//PageBean.countOffset(pageShowSize, currentPage);
			//String hql="select * from [JC_Web_System_DB].[dbo].[Sys_Users] ";
			String hql="from com.bean.SysUsers";
			List<SysUsers> list=sysUsersDAO.getByPage(pageCurrent);
			pb.setAllRow(sysUsersDAO.getPageCounts());
			pb.setPageSize(pageShowSize);
			//pb.setTotalPage(PageBean.countTotalPage(pageShowSize, allRow));
			//int countOffset=PageBean.countOffset(pageShowSize, pageCurrent);
			//List list= sysUsersDAO.queryForPage(hql,pageShowSize,pageCurrent);
			pb.setList(list);
			
			return pb;
		
	}
}
