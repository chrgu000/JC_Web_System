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

	protected UserListService userListService;     //�ö������ Spring ����ע��
	

	@Override
	public String execute() throws Exception {
		// System.out.println("�����¼ִ�и÷���excute");
		updateUserList();
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
			//ѭ��ɾ���û�id����
			userListService.DeleteUserById(Integer.parseInt(sourceArr[i]));
		}
		updateUserList();
		return "userList";
	}
	
	
	public void updateUserList(){
		//ˢ���û��б�ҳ��
		int pageCounts=userListService.getPageCounts();//�������ҳ������
		
		List<SysUsers> usersList = userListService.getByPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageCounts", pageCounts);
		request.getSession().setAttribute("usersList", usersList);
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
