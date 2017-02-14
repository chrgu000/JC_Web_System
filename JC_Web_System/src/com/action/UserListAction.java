package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserListService;

public class UserListAction extends ActionSupport {
	
	
	
	private static final long serialVersionUID = 1L;

	protected UserListService userListService;     //�ö������ Spring ����ע��
	

	@Override
	public String execute() throws Exception {
		// System.out.println("�����¼ִ�и÷���excute");

		List<SysUsers> usersList = userListService.getAllUsers();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.getSession().setAttribute("usersList", usersList);
		 
		return "userList";

	}
	
	public String gotoAddUser(){
		//����༭����
		HttpServletRequest request= ServletActionContext.getRequest();
		request.getSession().removeAttribute("editUser");
		return "userAdd";
	}
	
	public String gotoEditUser() throws Exception{
		HttpServletRequest request= ServletActionContext.getRequest();
		int userId=Integer.parseInt(request.getParameter("userId").trim());
		SysUsers editUser=userListService.getUserByID(userId);
		request.getSession().setAttribute("editUser", editUser);
		return "userEdit";
	}
	
	public String searchUserByT_N() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		int userType=Integer.parseInt(request.getParameter("userType"));
		String userName=request.getParameter("userName");
		
		List<SysUsers> usersList = userListService.getUsersByT_N(userType,userName);
		
		request.getSession().setAttribute("usersList", usersList);
		return "userList";
		
	}
	
	public String AddUser(){
		return "userAddSuccess";
	}
	
	
	//Spring����ע��Ķ��������get��set������������������get+��������Ϊ�˱��ڼ��䣬��������һ����ĸ���Դ�д��
    public void setUserListService(UserListService userListService)    
    {
        this.userListService = userListService;
    }
    public UserListService getUserListService()
    {
        return userListService;
    }
}
