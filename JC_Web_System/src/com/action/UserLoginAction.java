package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.ActionManager;

public class UserLoginAction extends ActionSupport {
	/*@Override
	public String execute() throws Exception {
		System.out.println("点击登录执行该方法");
		return "SUCCESS";
	}*/
	
	
	private static final long serialVersionUID = 1L;

	protected ActionManager mgr;     //该对象采用 Spring 依赖注入
	
	private String username;
	private String password;

	public String execute() throws Exception {
		System.out.println("点击登录执行该方法123");
		if(username.equals("") || username == null){
			return "FAILURE";
		}
		
		Integer userId = mgr.validLogin(username, password);
		
		if (userId != null) {
			System.out.println("合法用户");
			return "SUCCESS";
		} else {
			addActionError("用户名/密码不匹配");
			System.out.println("非法用户");
			return "FAILURE";
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
    public void setMgr(ActionManager mgr)    
    {
        this.mgr = mgr;
    }
    public ActionManager getMgr()
    {
        return mgr;
    }
}
