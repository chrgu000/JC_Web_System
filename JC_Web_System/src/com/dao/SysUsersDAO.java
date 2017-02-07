package com.dao;

import java.util.List;

import com.bean.SysUsers;

public interface SysUsersDAO {

	/**
     * 根据id查找用户
     * @param id 需要查找的用户id
     */  
    SysUsers get(Integer id);
    /**
     * 增加用户
     * @param SysUsers 需要增加的用户
     */       
    void save(SysUsers SysUsers);

    /**
     * 修改用户
     * @param SysUsers 需要修改的用户
     */  
    void update(SysUsers SysUsers);

    /**
     * 删除用户
     * @param id 需要删除的用户id
     */  
    void delete(Integer id);

    /**
     * 删除用户
     * @param SysUsers 需要删除的用户
     */  
    void delete(SysUsers SysUsers);

    /**
     * 查询全部用户
     * @return 获得全部用户
     */ 
    List<SysUsers> findAll();

    /**
     * 根据用户名，密码查找用户
     * @param SysUsersname 查询所需的用户名
     * @param pass 查询所需的密码
     * @return 对应的用户
     */ 
    SysUsers findSysUsersByNameAndPass(String SysUsersname , String password);
}
