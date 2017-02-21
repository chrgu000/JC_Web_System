package com.service.impl;

import java.util.List;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.dao.ISysUsersDAO;

public class UserListServiceImpl implements com.service.UserListService {

	public static final int pageShowSize=5;
	
	private ISysUsersDAO sysUsersDAO;
	
	public ISysUsersDAO getSysUsersDAO() {
		return this.sysUsersDAO;
	}
	
	public void setSysUsersDAO(ISysUsersDAO userDAO) {
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

	public void DeleteUserById(int userId) {
		// TODO Auto-generated method stub
		try {
			 sysUsersDAO.delete(userId);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getPageCounts(){
		// TODO Auto-generated method stub
		return sysUsersDAO.getPageCounts();
	}

	public List<SysUsers> getByPage(int i) {
		// TODO Auto-generated method stub
		
		/*int min=pageLinesNum*(i-1);
		int max=pageLinesNum*i+1;
		String sql="select * from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		*/
		
		try {
			return sysUsersDAO.getByPage(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PageBean queryForPage(int currentPage) {
		// TODO Auto-generated method stub
		PageBean pb=new PageBean();
		pb.init();
		pb.setCurrentPage(PageBean.countCurrentPage(currentPage));
		//PageBean.countOffset(pageShowSize, currentPage);
		String hql="select * from [JC_Web_System_DB].[dbo].[Sys_Users] ";
		int allRow=sysUsersDAO.getAllRowCount(hql);
		pb.setAllRow(allRow);
		pb.setPageSize(pageShowSize);
		pb.setTotalPage(PageBean.countTotalPage(pageShowSize, allRow));
		List list= sysUsersDAO.queryForPage(hql,pageShowSize,currentPage);
		pb.setList(list);
		
		return pb;
	}
	
}
