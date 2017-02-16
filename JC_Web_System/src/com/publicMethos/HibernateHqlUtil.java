package com.publicMethos;

import java.util.List;

public interface HibernateHqlUtil {
	public List<Object[]> queryHqlBySession(String hql, int

	n);

	public <T> List<T> queryHqlBySession(String hql, T bean);

	public Object queryHqlBySession(String hql);

	public int executeUpdate(String hql);
}
