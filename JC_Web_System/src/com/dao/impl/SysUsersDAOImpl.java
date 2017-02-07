package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.SysUsers;
import com.dao.SysUsersDAO;

public class SysUsersDAOImpl extends HibernateDaoSupport implements SysUsersDAO {

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
		return getHibernateTemplate().find("from test");
	}

	public SysUsers get(Integer id) {
		// TODO Auto-generated method stub
		return (SysUsers)getHibernateTemplate().get(SysUsers.class , id);
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
		// TODO Auto-generated method stub
		System.out.println("验证用户22222222");
		//delete(1);    //从数据库的test表中，成功删除一条记录
		//String[] args = {username , password};
		System.out.println("成功123abc");
 			
		List ul = getHibernateTemplate().find("from com.bean.User au where au.username = '"+ SysUsersname+"' and au.password = '"+ password+"'");

		if (ul.size() == 1)
        {
			System.out.println("OK 123abc");
            return (SysUsers)ul.get(0);
        }
		return null;
	}
}
