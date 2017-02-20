package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.PageBean;
import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

public class UserAction extends ActionSupport {
	/*@Override
	public String execute() throws Exception {
		System.out.println("�����¼ִ�и÷���");
		return "SUCCESS";
	}*/
	
	
	private static final long serialVersionUID = 1L;

	protected IUserService userService;     //�ö������ Spring ����ע��
	
	private int pageCurrent; // �ڼ�ҳ     
	private PageBean pageBean; // �����ֲ���Ϣ��bean 
	
	@Override
	public String execute() throws Exception {
		// System.out.println("�����¼ִ�и÷���excute");
		return "";

	}

	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Integer userId = userService.validLogin(username, password);
		if (userId != null) {
			SysUsers user=userService.getUserByID(userId);
			request.getSession().setAttribute("currentUser", user);
			this.setPageCurrent(1);
			//String s=this.pager();
			 this.pageBean = userService.queryForPage(this.getPageCurrent());
			return "LoginSuccess";
		} else {
			return "LoginFail";
		}
	}
	
	public String logOut(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("currentUser");
		//System.out.print("�Ƴ�session���");
		request.getSession().removeAttribute("usersList");
		return "LogOut";
	}
	
	
	//Spring����ע��Ķ��������get��set������������������get+��������Ϊ�˱��ڼ��䣬��������һ����ĸ���Դ�д��
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	
	public String pager(){  
	    //��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ         
	    this.pageBean = userService.queryForPage( pageCurrent);        
	    return "userList";  
	} 
	
	
}
