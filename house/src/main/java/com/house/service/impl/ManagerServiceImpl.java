package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.ManagerMapper;
import com.house.entity.Manager;
import com.house.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public int deleteByPrimaryKey(Integer managerId) {
		// TODO Auto-generated method stub
		return managerMapper.deleteByPrimaryKey(managerId);
	}

	@Override
	public int insert(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.insert(record);
	}

	@Override
	public int insertSelective(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.insertSelective(record);
	}

	@Override
	public Manager selectByPrimaryKey(Integer managerId) {
		// TODO Auto-generated method stub
		return managerMapper.selectByPrimaryKey(managerId);
	}

	@Override
	public int updateByPrimaryKeySelective(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Manager record) {
		// TODO Auto-generated method stub
		return managerMapper.updateByPrimaryKey(record);
	}

	@Override
	public Manager selectByAccount(String managerAccount) {
		// TODO Auto-generated method stub
		return managerMapper.selectByAccount(managerAccount);
	}

}
