package com.dao;

import java.util.HashMap;
import java.util.List;

import com.bean.PageBean;
import com.bean.SysUsers;

public interface ISysUsersDAO {

	/**
     * ����id�����û�
     * @param id ��Ҫ���ҵ��û�id
     */  
    SysUsers get(Integer id);
    /**
     * �����û�
     * @param SysUsers ��Ҫ���ӵ��û�
     */       
    void save(SysUsers SysUsers);

    /**
     * �޸��û�
     * @param SysUsers ��Ҫ�޸ĵ��û�
     */  
    void update(SysUsers SysUsers);

    /**
     * ɾ���û�
     * @param id ��Ҫɾ�����û�id
     */  
    void delete(Integer id);

    /**
     * ɾ���û�
     * @param SysUsers ��Ҫɾ�����û�
     */  
    void delete(SysUsers SysUsers);

    /**
     * ��ѯȫ���û�
     * @return ���ȫ���û�
     */ 
    List<SysUsers> findAll();

    /**
     * �����û�������������û�
     * @param SysUsersname ��ѯ������û���
     * @param pass ��ѯ���������
     * @return ��Ӧ���û�
     */ 
    SysUsers findSysUsersByNameAndPass(String SysUsersname , String password);
	List<SysUsers> getByT_N(int userType, String userName);
	int getPageCounts();
	PageBean<SysUsers> getByPage(HashMap<String, String> conditionList,int i);
	
	
	public List queryForPage(final String hql, final int offset,final int length);  
	public int getAllRowCount(String hql); 
	
}