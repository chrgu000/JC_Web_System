package com.publicMethos.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.PageBean;
import com.publicMethos.SqlUtil;

public class SqlUtilImpl extends HibernateDaoSupport implements SqlUtil {

	public static final int pageLinesNum = 5;// ÿҳ��ʾ����������

	/*
	 * ִ�в�ѯ��䣬����Ψһֵ�Ľ��eg:"select min(a.employeeid) from Emplyees a;"
	 * eg:"select count(*) from Emplyees a;"
	 */
	public Object queryHqlBySession(String sql) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		Object object = query.uniqueResult();
		session.close();
		return object;
	}

	/*
	 * ִ��hql/sql��ѯ��䣬�����ݷ��ص�column1~n��˳������
	 * eg:"select name as column1, sex as column2 from Emplyees a;"
	 */
	/*
	 * @SuppressWarnings("unchecked") public List<Object[]>
	 * queryHqlBySession(String sql, int n) { Session session =
	 * super.getSession(); SQLQuery query = session.createSQLQuery(sql); for(int
	 * i = 1; i <= n; i++) { query.addScalar("column"+ i); } return
	 * query.list(); }
	 */

	/*
	 * ִ��hql/sql��ѯ��䣬�����ݷ���bean�У�bean��name��sql��as��name��ͬ���Զ�ע��
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> queryHqlListBySession(String sql, T bean) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		SQLQuery query = session.createSQLQuery(sql).addEntity(bean.getClass());
		List<T> result = query.list();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T> PageBean<T> queryForPage(String DB_table_name,String Primarykey,
			HashMap<String, String> conditionList, Class<T> bean, int pageCurrent) {

		PageBean<T> pb = new PageBean<T>();
		pb.init();
		pb.setCurrentPage(PageBean.countCurrentPage(pageCurrent));
		List<T> list = (List<T>) this.queryHqlListBySession(DB_table_name,Primarykey,
				conditionList, bean,pageCurrent);
		int allRow = this.queryHqlRowsNum(DB_table_name,Primarykey, conditionList);
		pb.setAllRow(allRow);// �����ܼ�¼��
		pb.setPageSize(pageLinesNum);// ����ҳ����ʾ����
		pb.setTotalPage(PageBean.countTotalPage(pageLinesNum, allRow));// ����ҳ��������
		pb.setList(list);

		return pb;

	}

	public <T> List<T> queryHqlListBySession(String DB_table_name,String Primarykey,
			HashMap<String, String> conditionList, Class<T> bean, int pageCurrent) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		String conditionStr = " where 1=1 and ";
		if (conditionList != null) {

			Iterator<Entry<String, String>> iter = conditionList.entrySet()
					.iterator();
			while (iter.hasNext()) {
				Entry<String, String> entry = iter.next();
				conditionStr = conditionStr + entry.getKey() + entry.getValue()
						+ " and ";
			}
		}
		conditionStr = conditionStr + "1=1";

		String sql="select top " +
				pageLinesNum+" * from " +
				DB_table_name+" "+conditionStr+
				" and " +Primarykey+
				" not in(select top " +
				(pageCurrent-1)*pageLinesNum+" "+Primarykey +
				" from "+DB_table_name+" "+conditionStr+
				" order by "+Primarykey+" asc) " +
				"order by "+Primarykey+" asc";
				
		//String sql = "select * from " + DB_table_name + conditionStr;
		SQLQuery query = session.createSQLQuery(sql).addEntity(bean);
		List<T> result = query.list();
		session.close();
		return result;
	}

	// ���������б�conditiaonList��ѯ���ݿ�DB_table_name�з�������������������
	public int queryHqlRowsNum(String DB_table_name,String Primarykey,
			HashMap<String, String> conditionList) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		String conditionStr = " where 1=1 and ";
		Iterator<Entry<String, String>> iter = conditionList.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			conditionStr = conditionStr + entry.getKey() + entry.getValue()
					+ " and ";
		}
		conditionStr = conditionStr + "1=1";
		String sql = "select count(*) from " + DB_table_name + conditionStr;
		session.close();

		return this.queryHqlPagesNum(sql);// (int)Math.ceil((double)this.queryHqlPagesNum(sql)/pageLinesNum);
	}

	public int queryHqlPagesNum(String sql) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		int result = (Integer) query.list().get(0);
		session.close();
		return result;
	}

	/*
	 * ִ��hql/sql������䣨delete��update����������Ӱ�����������
	 * eg:"delete from Emplyees a where a.id<10;"
	 */
	public int executeUpdate(String sql) {
		Session session = getHibernateTemplate().getSessionFactory()
				.openSession();
		SQLQuery query = session.createSQLQuery(sql);
		int count = query.executeUpdate();
		session.close();
		return count;
	}

}