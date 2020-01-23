package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.ManagerMapper;
import com.petFoster.domain.Manager;
import com.petFoster.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerMapper ManagerMapper;
	
	public int deleteByPrimaryKey(Long mId) {
		// TODO Auto-generated method stub
		return ManagerMapper.deleteByPrimaryKey(mId);
	}

	public int insert(Manager record) {
		// TODO Auto-generated method stub
		return ManagerMapper.insert(record);
	}

	public int insertSelective(Manager record) {
		// TODO Auto-generated method stub
		return ManagerMapper.insertSelective(record);
	}

	public Manager selectByPrimaryKey(Long mId) {
		// TODO Auto-generated method stub
		return ManagerMapper.selectByPrimaryKey(mId);
	}

	public int updateByPrimaryKeySelective(Manager record) {
		// TODO Auto-generated method stub
		return ManagerMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Manager record) {
		// TODO Auto-generated method stub
		return ManagerMapper.updateByPrimaryKey(record);
	}

	public List<Manager> listByAll() {
		// TODO Auto-generated method stub
		return ManagerMapper.listByAll();
	}

	public Manager listByAccount(String accountName) {
		// TODO Auto-generated method stub
		return ManagerMapper.listByAccount(accountName);
	}

}
