package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class UserAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	protected IUserService userService;     //�ö������ Spring ����ע��

	//Spring����ע��Ķ��������get��set������������������get+��������Ϊ�˱��ڼ��䣬��������һ����ĸ���Դ�д��
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }
	
	public int pageCurrent; //��ǰ��ʾ���û���Ϣ��ҳ���־
	
	@Override
	public String execute() throws Exception {
		//user.action���õķ���
		return "";

	}

	public String login(){
		//user!login.action���õķ���
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
		//user!logOut.action���õķ���
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("currentUser");
		request.getSession().removeAttribute("pageBean");
		return "LogOut";
	}
	
	
	//����ҳ��ˢ���û��б�ͨ��json���ص�ǰ̨���ֲ�ˢ��
	public void updateUserPage(){
		PageBean pageBean = userService.queryForPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
		
	}
	
	
	//�����û���ͨ��jason���ص�ǰ̨���ֲ�ˢ��
	public void findPage(){
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		this.pageCurrent=pageNum;
		PageBean pageBean = userService.queryForPage(pageCurrent);
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
	}
	
	
	
}
