package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class UserAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	protected IUserService userService;     //该对象采用 Spring 依赖注入

	//Spring依赖注入的对象必须有get、set方法。方法命名规则：get+变量名。为了便于记忆，变量名第一个字母可以大写。
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }
	
	public int pageCurrent; //当前显示的用户信息表页面标志
	
	@Override
	public String execute() throws Exception {
		//user.action调用的方法
		return "";

	}

	public String login(){
		//user!login.action调用的方法
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Integer userId = userService.validLogin(username, password);
		if (userId != null) {
			SysUsers user=userService.getUserByID(userId);
			request.getSession().setAttribute("currentUser", user);
			this.pageCurrent=1;
			//String s=this.pager();
			PageBean pageBean = userService.queryForPage(this.pageCurrent);
			
			request.getSession().setAttribute("pageBean", pageBean);
			 
			return "LoginSuccess";
		} else {
			return "LoginFail";
		}
	}
	
	public String logOut(){
		//user!logOut.action调用的方法
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("currentUser");
		request.getSession().removeAttribute("pageBean");
		return "LogOut";
	}
	
	
	//按照页码刷新用户列表，通过json返回到前台，局部刷新
	public void updateUserPage(){
		PageBean pageBean = userService.queryForPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
		
	}
	
	
	//查找用户，通过jason返回到前台，局部刷新
	public void findPage(){
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		this.pageCurrent=pageNum;
		PageBean pageBean = userService.queryForPage(pageCurrent);
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
	}
	
	
	
}
