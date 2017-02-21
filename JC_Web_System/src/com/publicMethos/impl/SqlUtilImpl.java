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

	public static final int pageLinesNum = 5;// 每页显示的数据条数

	/*
	 * 执行查询语句，返回唯一值的结果eg:"select min(a.employeeid) from Emplyees a;"
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
	 * 执行hql/sql查询语句，将数据返回到column1~n，顺序排列
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
	 * 执行hql/sql查询语句，将数据返回bean中，bean的name和sql中as的name相同，自动注入
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
		pb.setAllRow(allRow);// 设置总记录数
		pb.setPageSize(pageLinesNum);// 设置页面显示行数
		pb.setTotalPage(PageBean.countTotalPage(pageLinesNum, allRow));// 设置页面总数量
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

	// 依照条件列表conditiaonList查询数据库DB_table_name中符合条件的数据总条数
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
	 * 执行hql/sql更新语句（delete，update），返回受影响的数据条数
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