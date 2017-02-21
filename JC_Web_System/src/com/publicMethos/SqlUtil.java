package com.publicMethos;

import java.util.HashMap;
import java.util.List;

import com.bean.PageBean;

public interface SqlUtil {
	
	//public List<Object[]> queryHqlBySession(String hql, int n);

	public <T> List<T> queryHqlListBySession(String hql, T bean);

	public Object queryHqlBySession(String hql);

	public int queryHqlPagesNum(String sql);
	
	public int executeUpdate(String hql);
	
	
	//public int queryHqlRowsNum(String DB_table_name,HashMap<String,String> conditionList);
	
	//public <T> List<T> queryHqlListBySession(String DB_table_name, HashMap<String,String> conditionList,T bean);
	
	public <T> PageBean<T> queryForPage(String DB_table_name,String Primarykey,
			HashMap<String,String> conditionList,Class<T> bean,
			int pageCurrent);
	
	
}
