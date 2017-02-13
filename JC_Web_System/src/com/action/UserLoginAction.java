package com.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserListService;
import com.service.UserLoginService;

public class UserLoginAction extends ActionSupport {
	/*@Override
	public String execute() throws Exception {
		System.out.println("点击登录执行该方法");
		return "SUCCESS";
	}*/
	
	
	private static final long serialVersionUID = 1L;

	protected UserLoginService userLoginService;     //该对象采用 Spring 依赖注入
	protected UserListService userListService; 
	
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		// System.out.println("点击登录执行该方法excute");
		Integer userId = userLoginService.validLogin(username, password);
		if (userId != null) {

			SysUsers user=userListService.getUserByID(userId);
			List<SysUsers> usersList = userListService.getAllUsers();
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("currentUser", user);
			request.getSession().setAttribute("usersList", usersList);
			return "LoginSuccess";
		} else {
			return "LoginFail";
		}

	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	//Spring依赖注入的对象必须有get、set方法。方法命名规则：get+变量名。为了便于记忆，变量名第一个字母可以大写。
    public void setUserLoginService(UserLoginService userLoginService)    
    {
        this.userLoginService = userLoginService;
    }
    public UserLoginService getUserLoginService()
    {
        return userLoginService;
    }

	public UserListService getUserListService() {
		return userListService;
	}

	public void setUserListService(UserListService userListService) {
		this.userListService = userListService;
	}
}
