package com.publicMethos.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.BeansException;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.ApplicationContextAware;  
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.publicMethos.SqlUtil;
  
public class SqlUtilImpl extends HibernateDaoSupport implements   SqlUtil{  
      
		
		
		/*ִ�в�ѯ��䣬����Ψһֵ�Ľ��
		 *eg:"select min(a.employeeid) from Emplyees a;"
		 *eg:"select count(*) from Emplyees a;" */
	   public Object queryHqlBySession(String sql) {
		   Session session=getHibernateTemplate().getSessionFactory().openSession();
		   SQLQuery query=session.createSQLQuery(sql);
		   Object object = query.uniqueResult();
		   session.close();
	       return object;
	   }
	   
		/*
		 ִ��hql/sql��ѯ��䣬�����ݷ��ص�column1~n��˳������
		 * eg:"select name as column1, sex as column2 from Emplyees a;"
		 */
		/*@SuppressWarnings("unchecked")
		public List<Object[]> queryHqlBySession(String sql, int n) {
			Session session = super.getSession();
			SQLQuery query = session.createSQLQuery(sql);
			for(int i = 1; i <= n; i++) {
				query.addScalar("column"+ i);
			}
			return query.list();
		}*/
		
		
		/*
		 ִ��hql/sql��ѯ��䣬�����ݷ���bean�У�bean��name��sql��as��name��ͬ���Զ�ע��
		 */
		@SuppressWarnings("unchecked")
		public <T> List<T> queryHqlListBySession(String sql, T bean) {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query=session.createSQLQuery(sql).addEntity(bean.getClass());
			List<T> result = query.list();
			session.close();
			return result;
		}
		
		public int queryHqlPagesNum(String sql) {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query=session.createSQLQuery(sql);
			int result = (Integer) query.list().get(0);
			session.close();
			return result;
		}
		
		/*
		 ִ��hql/sql������䣨delete��update����������Ӱ�����������
		 * eg:"delete from Emplyees a where a.id<10;"
		 */
		public int executeUpdate(String sql) {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query=session.createSQLQuery(sql);
			int count = query.executeUpdate();
			session.close();
			return count;
		}
		
}  