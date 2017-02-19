package com.publicMethos;

import java.util.List;

public interface SqlUtil {
	
	//public List<Object[]> queryHqlBySession(String hql, int n);

	public <T> List<T> queryHqlListBySession(String hql, T bean);

	public Object queryHqlBySession(String hql);

	public int queryHqlPagesNum(String sql);
	
	public int executeUpdate(String hql);
}
