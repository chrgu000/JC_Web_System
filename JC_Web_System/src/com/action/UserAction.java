package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.bean.PageBean;
import com.bean.SysUsers;
import com.opensymphony.xwork2.ActionSupport;
import com.publicMethos.IJsonManager;
import com.service.IUserService;

/**
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private IUserService userService;     //�ö������ Spring ����ע��
	
	private IJsonManager jsonManager;  //springע��jsonManager
	

	public IJsonManager getJsonManager() {
		return jsonManager;
	}
	public void setJsonManager(IJsonManager jsonManager) {
		this.jsonManager = jsonManager;
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
	
	public int pageCurrent=1; //��ǰ��ʾ���û���Ϣ��ҳ���־
	
	@Override
	public String execute() throws Exception {
		//user.action���õķ���
		return "";

	}

	
	/**���ã�user!login.action���õķ���
	 * ����ֵ��String
	 * ����ʱ�䣺8:23:02 PM  �����ߣ�wulm
	 */
	public String login(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		SysUsers user = userService.validLogin(username, password);
		if (user != null) {
			request.getSession().setAttribute("currentUser", user);
			this.pageCurrent=1;
			PageBean<SysUsers> pageBean = userService.queryForPage(this.pageCurrent);
			request.getSession().setAttribute("pageBean", pageBean);
			return "LoginSuccess";
		} else {
			return "LoginFail";
		}
	}
	
	
	/**���ã�user!logOut.action���õķ���
	 * ����ֵ��LogOut
	 * ����ʱ�䣺8:24:51 PM  �����ߣ�wulm
	 */
	/*public String logOut(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("currentUser");
		request.getSession().removeAttribute("pageBean");
		return "LogOut";
	}*/
	
	
	
	/**���ã�����ҳ��ˢ���û��б�ͨ��json���ص�ǰ̨���ֲ�ˢ��
	 * ����ֵ��
	 * ����ʱ�䣺8:26:17 PM  �����ߣ�wulm
	 */
	/*public void updateUserPage(){
		PageBean pageBean = userService.queryForPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
		
	}*/
	
	
	
	/**���ã������û���ͨ��jason���ص�ǰ̨���ֲ�ˢ��
	 * ����ֵ��
	 * ����ʱ�䣺8:27:06 PM  �����ߣ�wulm
	 */
	public void findPage(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		this.pageCurrent=pageNum;
		PageBean<SysUsers> pageBean = userService.queryForPage(pageCurrent);
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
	}
	
	public void updateUserTable() {
	    try {
	    	HttpServletRequest request=ServletActionContext.getRequest();
	        int pageNum = Integer.parseInt(request.getParameter("pageNum"));  
	        PageBean<SysUsers> pageBean = userService.queryForPage(pageNum);  
//	        System.out.println(jsonManager);
//	        System.out.println(userService);
	        String jsonData=jsonManager.Object2Json(pageBean.getList());
	        System.out.println(jsonData);
	        
	        HttpServletResponse response =   ServletActionContext.getResponse();
	        response.getWriter().write(jsonData);//����json���ݵ�ǰ̨
	        response.getWriter().flush();
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
	
}
