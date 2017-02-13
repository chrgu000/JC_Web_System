package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserLoginService;

public class UserLoginAction extends ActionSupport {
	/*@Override
	public String execute() throws Exception {
		System.out.println("�����¼ִ�и÷���");
		return "SUCCESS";
	}*/
	
	
	private static final long serialVersionUID = 1L;

	protected UserLoginService userLoginService;     //�ö������ Spring ����ע��
	
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		// System.out.println("�����¼ִ�и÷���excute");

		Integer userId = userLoginService.validLogin(username, password);

		if (userId != null) {

			// ���û���Ϣ����session�б���
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
			addActionMessage("<script>alert('�û��������ڻ��������');</script>");
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
	
	//Spring����ע��Ķ��������get��set������������������get+��������Ϊ�˱��ڼ��䣬��������һ����ĸ���Դ�д��
    public void setUserLoginService(UserLoginService userLoginService)    
    {
        this.userLoginService = userLoginService;
    }
    public UserLoginService getUserLoginService()
    {
        return userLoginService;
    }
}
