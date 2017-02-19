package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.bean.SysUsers;
import com.dao.SysUsersDAO;
import com.publicMethos.SqlUtil;

public class SysUsersDAOImpl extends HibernateDaoSupport implements SysUsersDAO {

	@Resource SessionFactory sessionFactory;
	
	public static final int pageLinesNum=1;//定义每个页面显示的列表行数
	
	private SqlUtil sqlUtil;
	
	public SqlUtil getSqlUtil() {
		return sqlUtil;
	}

	public void setSqlUtil(SqlUtil sqlUtil) {
		this.sqlUtil = sqlUtil;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(SysUsers.class , id));
	}

	public void delete(SysUsers user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	public List<SysUsers> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from com.bean.SysUsers");
	}

	public SysUsers get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(SysUsers.class , id);
	}

	public void save(SysUsers user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	public void update(SysUsers user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(user);
	}

	public SysUsers findSysUsersByNameAndPass(String SysUsersname,
			String password) {
		
		List<SysUsers> ul = getHibernateTemplate().find("from com.bean.SysUsers au where au.userLoginName = '"+ SysUsersname+"' and au.userPwd = '"+ password+"'");

		if (ul.size() == 1)
        {
			//System.out.println("查到一条合法用户数据");
            return ul.get(0);
            
        }
		return null;
	}

	
	//页面值查询数据...未测试
	
	public List<SysUsers> getByPage(int pageNum){
		
		
		//几种典型的分页sql，下面例子是每页50条，198*50=9900，取第199页数据。
		//每页显示m条，取第n页，则rownuber>m*(n-1),rownuber<m*(n-1)+m+1
		int min=pageLinesNum*(pageNum-1);
		int max=pageLinesNum*pageNum+1;
		String sql="select user_id,user_login_name," +
				"user_pwd,user_name,user_phone_num," +
				"user_email,user_type  " +
				"from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		
		//Session session=getHibernateTemplate().getSessionFactory().openSession();//打开新的session查询hql
		//SQLQuery query=session.createSQLQuery(sql).addEntity(SysUsers.class);
		//List<SysUsers> list = query.list();
		//session.close();
		List<SysUsers> list=(List<SysUsers>) sqlUtil.queryHqlListBySession(sql,new SysUsers() );
		
		return list;
	}
	
	//按条件页面值查询数据...未测试
	public List<SysUsers> getByPageT_N(int pageNum,int userType, String userName){
		
		//几种典型的分页sql，下面例子是每页50条，198*50=9900，取第199页数据。
		//每页显示m条，取第n页，则rownuber>m*(n-1),rownuber<m*(n-1)+m+1
		int min=pageLinesNum*(pageNum-1);
		int max=pageLinesNum*pageNum+1;
		String sql="select * from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		if(userType==-1){
			sql+=" and user_name like '%"+userName+"%'";
		}else{
			sql+=" and user_type="+userType+" and user_name like '%"+userName+"%'";
		}
		
		List<SysUsers> list=(List<SysUsers>) sqlUtil.queryHqlBySession(sql);
		return list;
	}
	
	//获取查询页面总量。。未测试
	public int getPageCounts(){
		String sql="";
		sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		return (int)Math.ceil((double)sqlUtil.queryHqlPagesNum(sql)/pageLinesNum);//通过依赖注入执行hql语句
	}
	
	//按条件   获取查询页面数量...未测试
	public int getPageCountsByT_N(int userType, String userName){
		String sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		if(userType==-1){
			 sql+="where user_name like '%"+userName+"%'";
		}else{
			sql+="where user_type="+userType+" and " +
				"user_name like '%"+userName+"%'";
		}
		//SQLManager sqlManager=(SQLManager)SqlUtil.getBean("sqlManager");
		return (int)Math.ceil((double)sqlUtil.queryHqlPagesNum(sql)/pageLinesNum);//通过依赖注入执行hql语句
	}
	
	
	
	public List<SysUsers> getByT_N(int userType, String userName) {
		// TODO Auto-generated method stub
		if(userType==-1){
			return getHibernateTemplate().find("from com.bean.SysUsers where userName like '%"+userName+"%'");
		}else{
			return getHibernateTemplate().find("from com.bean.SysUsers where userType="+userType+" and userName like '%"+userName+"%'");
		}
	}

}
