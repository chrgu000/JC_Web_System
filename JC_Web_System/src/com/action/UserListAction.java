package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserListService;

public class UserListAction extends ActionSupport {
	
	
	
	private static final long serialVersionUID = 1L;

	protected UserListService userListService;     //该对象采用 Spring 依赖注入
	

	@Override
	public String execute() throws Exception {
		// System.out.println("点击登录执行该方法excute");
		updateUserList();
		return "userList";

	}
	
	public String gotoAddUser(){
		//清除编辑缓存
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
	
	public String DeleteUser() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		int userId=Integer.parseInt(request.getParameter("userId").trim());
		userListService.DeleteUserById(userId);
		updateUserList();
		return "userList";
	}
	
	public String DeleteUserByIds() throws Exception {
		HttpServletRequest request= ServletActionContext.getRequest();
		String ids=request.getParameter("usersIds");
		String[] sourceArr=ids.split(",");
		for(int i=0;i<sourceArr.length;i++){
			//System.out.print(sourceArr[i]+"-----");
			//循环删除用户id数组
			userListService.DeleteUserById(Integer.parseInt(sourceArr[i]));
		}
		updateUserList();
		return "userList";
	}
	
	
	public void updateUserList(){
		//刷新用户列表页面
		int pageCounts=userListService.getPageCounts();//获得数据页面总数
		
		List<SysUsers> usersList = userListService.getByPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageCounts", pageCounts);
		request.getSession().setAttribute("usersList", usersList);
	}
	
	public String AddUser(){
		return "userAddSuccess";
	}
	
	
	//Spring依赖注入的对象必须有get、set方法。方法命名规则：get+变量名。为了便于记忆，变量名第一个字母可以大写。
    public void setUserListService(UserListService userListService)    
    {
        this.userListService = userListService;
    }
    public UserListService getUserListService()
    {
        return userListService;
    }
}
