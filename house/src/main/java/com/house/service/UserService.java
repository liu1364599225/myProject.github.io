package com.house.service;

import com.house.entity.User;

public interface UserService {
	int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    /**
	 * 通过用户账号查询对应用户信息
	 */
    User selectByAccount(String userAccount);
}
