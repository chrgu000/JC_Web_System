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
	
	public static final int pageLinesNum=1;//����ÿ��ҳ����ʾ���б�����
	
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
			//System.out.println("�鵽һ���Ϸ��û�����");
            return ul.get(0);
            
        }
		return null;
	}

	
	//ҳ��ֵ��ѯ����...δ����
	
	public List<SysUsers> getByPage(int pageNum){
		
		
		//���ֵ��͵ķ�ҳsql������������ÿҳ50����198*50=9900��ȡ��199ҳ���ݡ�
		//ÿҳ��ʾm����ȡ��nҳ����rownuber>m*(n-1),rownuber<m*(n-1)+m+1
		int min=pageLinesNum*(pageNum-1);
		int max=pageLinesNum*pageNum+1;
		String sql="select user_id,user_login_name," +
				"user_pwd,user_name,user_phone_num," +
				"user_email,user_type  " +
				"from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		
		//Session session=getHibernateTemplate().getSessionFactory().openSession();//���µ�session��ѯhql
		//SQLQuery query=session.createSQLQuery(sql).addEntity(SysUsers.class);
		//List<SysUsers> list = query.list();
		//session.close();
		List<SysUsers> list=(List<SysUsers>) sqlUtil.queryHqlListBySession(sql,new SysUsers() );
		
		return list;
	}
	
	//������ҳ��ֵ��ѯ����...δ����
	public List<SysUsers> getByPageT_N(int pageNum,int userType, String userName){
		
		//���ֵ��͵ķ�ҳsql������������ÿҳ50����198*50=9900��ȡ��199ҳ���ݡ�
		//ÿҳ��ʾm����ȡ��nҳ����rownuber>m*(n-1),rownuber<m*(n-1)+m+1
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
	
	//��ȡ��ѯҳ����������δ����
	public int getPageCounts(){
		String sql="";
		sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		return (int)Math.ceil((double)sqlUtil.queryHqlPagesNum(sql)/pageLinesNum);//ͨ������ע��ִ��hql���
	}
	
	//������   ��ȡ��ѯҳ������...δ����
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
		return (int)Math.ceil((double)sqlUtil.queryHqlPagesNum(sql)/pageLinesNum);//ͨ������ע��ִ��hql���
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
