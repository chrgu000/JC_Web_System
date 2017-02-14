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
			//System.out.println("查到一条合法用户数据");
            return (SysUsers)ul.get(0);
        }
		return null;
	}
}
