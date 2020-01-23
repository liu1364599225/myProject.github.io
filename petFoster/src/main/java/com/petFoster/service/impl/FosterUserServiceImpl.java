package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.FosterUserMapper;
import com.petFoster.domain.FosterUser;
import com.petFoster.service.FosterUserService;

public class FosterUserServiceImpl implements FosterUserService{
	@Autowired
	private FosterUserMapper FosterUserMapper;
	
	public int deleteByPrimaryKey(Long fuId) {
		// TODO Auto-generated method stub
		return FosterUserMapper.deleteByPrimaryKey(fuId);
	}

	public int insert(FosterUser record) {
		// TODO Auto-generated method stub
		return FosterUserMapper.insert(record);
	}

	public int insertSelective(FosterUser record) {
		// TODO Auto-generated method stub
		return FosterUserMapper.insertSelective(record);
	}

	public FosterUser selectByPrimaryKey(Long fuId) {
		// TODO Auto-generated method stub
		return FosterUserMapper.selectByPrimaryKey(fuId);
	}

	public int updateByPrimaryKeySelective(FosterUser record) {
		// TODO Auto-generated method stub
		return FosterUserMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(FosterUser record) {
		// TODO Auto-generated method stub
		return FosterUserMapper.updateByPrimaryKey(record);
	}

	public List<FosterUser> listByAll() {
		// TODO Auto-generated method stub
		return FosterUserMapper.listByAll();
	}

	public FosterUser listByAccount(String accountName) {
		// TODO Auto-generated method stub
		return FosterUserMapper.listByAccount(accountName);
	}

	public List<FosterUser> listByRequestStatus(String requestStatus) {
		// TODO Auto-generated method stub
		return FosterUserMapper.listByRequestStatus(requestStatus);
	}

}
