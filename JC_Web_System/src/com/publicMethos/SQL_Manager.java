package com.publicMethos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class SQL_Manager {

	//执行原生sql查询语句，并返回对象列表
	public static List QuerySQL(String sql)  throws Exception{
		 SQLQuery query  =  sessionFactory.getCurrentSession().createSQLQuery(hql); //返回对象
		return query.list(); 
		
	}
	
	public static int getPageCount(String sql) throws Exception{
		Configuration config = new Configuration().configure();
		SessionFactory sf     = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createSQLQuery(sql); //返回对象
		return Integer.parseInt(String.valueOf(query.list().get(0))); 
	}
	
}
