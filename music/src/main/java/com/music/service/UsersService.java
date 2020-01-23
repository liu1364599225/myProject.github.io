package com.music.service;

import com.music.entity.Users;

public interface UsersService {
    int deleteByPrimaryKey(Integer usersId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer usersId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    /**
     * 通过用户名与密码查询用户是否存在
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    Users selectByUsernameAndPassword(String username,String password);
    /**
     * 通过用户名查询用户是否重复
     * @param username
     * @return 用户对象
     */
	Users selectByUsername(String username);
}