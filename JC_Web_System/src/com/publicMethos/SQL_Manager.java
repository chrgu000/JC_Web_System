package com.publicMethos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public final class SQL_Manager {

	//ִ��ԭ��sql��ѯ��䣬�����ض����б�
	public static List QuerySQL(String sql)  throws Exception{
		 SQLQuery query  =  sessionFactory.getCurrentSession().createSQLQuery(hql); //���ض���
		return query.list(); 
		
	}
	
	public static int getPageCount(String sql) throws Exception{
		Configuration config = new Configuration().configure();
		SessionFactory sf     = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createSQLQuery(sql); //���ض���
		return Integer.parseInt(String.valueOf(query.list().get(0))); 
	}
	
}
