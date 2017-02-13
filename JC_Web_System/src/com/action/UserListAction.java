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

		List<SysUsers> allUsers = userListService.getAllUsers();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		request.getSession().setAttribute("allUsers", allUsers);
		 
		return "userList";

	}
	
	public String gotoAddUser(){
		return "userAdd";
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
