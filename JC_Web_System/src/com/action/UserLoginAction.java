package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserLoginService;

public class UserLoginAction extends ActionSupport {
	/*@Override
	public String execute() throws Exception {
		System.out.println("点击登录执行该方法");
		return "SUCCESS";
	}*/
	
	
	private static final long serialVersionUID = 1L;

	protected UserLoginService userLoginService;     //该对象采用 Spring 依赖注入
	
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		// System.out.println("点击登录执行该方法excute");

		Integer userId = userLoginService.validLogin(username, password);

		if (userId != null) {

			// 将用户信息存入session中保存
			Map<String, Object> session = ActionContext.getContext()
					.getSession();

			if (session.containsKey("CURRENT_USER_ID")) {
				session.remove("CURRENT_USER_ID");
				session.remove("CURRENT_USER_NAME");
				session.remove("CURRENT_USER_PWD");
			}
			session.put("CURRENT_USER_ID", userId);
			session.put("CURRENT_USER_NAME", username);
			session.put("CURRENT_USER_PWD", password);
			if (userId == 1) {
				session.put("CURRENT_USER_TYPE", "1");
				return "LoginSuccess";
			} else {
				session.put("CURRENT_USER_TYPE", "0");
				return "LoginSuccess";
			}
		} else {
			addActionMessage("<script>alert('用户名不存在或密码错误！');</script>");
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
}
