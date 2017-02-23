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

	private IUserService userService;     //该对象采用 Spring 依赖注入
	
	private IJsonManager jsonManager;  //spring注入jsonManager
	

	public IJsonManager getJsonManager() {
		return jsonManager;
	}
	public void setJsonManager(IJsonManager jsonManager) {
		this.jsonManager = jsonManager;
	}
	//Spring依赖注入的对象必须有get、set方法。方法命名规则：get+变量名。为了便于记忆，变量名第一个字母可以大写。
    public void setUserService(IUserService userLoginService)    
    {
        this.userService = userLoginService;
    }
    public IUserService getUserService()
    {
        return userService;
    }
	
	public int pageCurrent=1; //当前显示的用户信息表页面标志
	
	@Override
	public String execute() throws Exception {
		//user.action调用的方法
		return "";

	}

	
	/**作用：user!login.action调用的方法
	 * 返回值：String
	 * 创建时间：8:23:02 PM  创建者：wulm
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
	
	
	/**作用：user!logOut.action调用的方法
	 * 返回值：LogOut
	 * 创建时间：8:24:51 PM  创建者：wulm
	 */
	/*public String logOut(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("currentUser");
		request.getSession().removeAttribute("pageBean");
		return "LogOut";
	}*/
	
	
	
	/**作用：按照页码刷新用户列表，通过json返回到前台，局部刷新
	 * 返回值：
	 * 创建时间：8:26:17 PM  创建者：wulm
	 */
	/*public void updateUserPage(){
		PageBean pageBean = userService.queryForPage(1);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("pageBean", pageBean);
		//return "userList";
		
	}*/
	
	
	
	/**作用：查找用户，通过jason返回到前台，局部刷新
	 * 返回值：
	 * 创建时间：8:27:06 PM  创建者：wulm
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
	        response.getWriter().write(jsonData);//返回json数据到前台
	        response.getWriter().flush();
	    }catch (Exception e){
	        e.printStackTrace();
	    }
	    
	}
	
}
