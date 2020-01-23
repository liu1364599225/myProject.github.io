package com.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.UsersMapper;
import com.music.entity.Users;
import com.music.service.UsersService;

public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer usersId) {
		// TODO Auto-generated method stub
		return usersMapper.deleteByPrimaryKey(usersId);
	}

	@Override
	public int insert(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer usersId) {
		// TODO Auto-generated method stub
		return usersMapper.selectByPrimaryKey(usersId);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKey(record);
	}

	@Override
	public Users selectByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return usersMapper.selectByUsernameAndPassword(username, password);
	}

	@Override
	public Users selectByUsername(String username) {
		// TODO Auto-generated method stub
		return usersMapper.selectByUsername(username);
	}

}
