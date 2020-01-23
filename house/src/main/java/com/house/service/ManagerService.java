package com.house.service;

import com.house.entity.Manager;

public interface ManagerService {
	int deleteByPrimaryKey(Integer managerId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer managerId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    
    /**
	 * 通过用户账号查询对应管理员信息
	 */
	Manager selectByAccount(String managerAccount);
}
