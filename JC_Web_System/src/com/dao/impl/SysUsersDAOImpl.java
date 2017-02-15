package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.SysUsers;
import com.dao.SysUsersDAO;
import com.publicMethos.SQL_Manager;

public class SysUsersDAOImpl extends HibernateDaoSupport implements SysUsersDAO {

	public static final int pageLinesNum=8;//����ÿ��ҳ����ʾ���б�����
	
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
		
		List ul = getHibernateTemplate().find("from com.bean.SysUsers au where au.userLoginName = '"+ SysUsersname+"' and au.userPwd = '"+ password+"'");

		if (ul.size() == 1)
        {
			//System.out.println("�鵽һ���Ϸ��û�����");
            return (SysUsers)ul.get(0);
            
        }
		return null;
	}

	
	//ҳ��ֵ��ѯ����...δ����
	public List<SysUsers> getByPage(int pageNum)  throws Exception{
		
		//���ֵ��͵ķ�ҳsql������������ÿҳ50����198*50=9900��ȡ��199ҳ���ݡ�
		//ÿҳ��ʾm����ȡ��nҳ����rownuber>m*(n-1),rownuber<m*(n-1)+m+1
		int min=pageLinesNum*(pageNum-1);
		int max=pageLinesNum*pageNum+1;
		String sql="select * from (select row_number()over" +
				"(order by user_id)rownumber,* from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users])a " +
				"where rownumber>"+min+" and rownumber<" +max;
		
		List<SysUsers> list=SQL_Manager.QuerySQL(sql);
		
		return list;
	}
	
	//��ȡ��ѯҳ����������δ����
	public int getPageCounts() throws Exception{
		String sql="";
		sql="select count(*) from " +
				"[JC_Web_System_DB].[dbo].[Sys_Users] ";
		
		return (int)Math.ceil((double)SQL_Manager.getPageCount(sql)/pageLinesNum);
	}
	
	//��������ȡ��ѯҳ������...δ����
	public int getPageCountsByT_N(int userType, String userName) throws Exception{
		String sql="";
		if(userType==-1){
			sql="select count(*) from " +
					"[JC_Web_System_DB].[dbo].[Sys_Users] " +
					"where user_name like '%"+userName+"%'";
		}else{
			sql="select count(*) from " +
					"[JC_Web_System_DB].[dbo].[Sys_Users] "+
					"where user_type="+userType+" and " +
							"user_name like '%"+userName+"%'";
		}
		
		return (int)Math.ceil((double)SQL_Manager.getPageCount(sql)/pageLinesNum);
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
