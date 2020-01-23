package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.FosterFamilyMapper;
import com.petFoster.domain.FosterFamily;
import com.petFoster.service.FosterFamilyService;

public class FosterFamilyServiceImpl implements FosterFamilyService{
	@Autowired
	private FosterFamilyMapper FosterFamilyMapper;

	public int deleteByPrimaryKey(Long fId) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.deleteByPrimaryKey(fId);
	}

	public int insert(FosterFamily record) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.insert(record);
	}

	public int insertSelective(FosterFamily record) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.insertSelective(record);
	}

	public FosterFamily selectByPrimaryKey(Long fId) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.selectByPrimaryKey(fId);
	}

	public int updateByPrimaryKeySelective(FosterFamily record) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(FosterFamily record) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.updateByPrimaryKey(record);
	}

	public List<FosterFamily> listByAll() {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.listByAll();
	}

	public FosterFamily listByAccount(String accountName) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.listByAccount(accountName);
	}

	public List<FosterFamily> listByRequestStatus(String requestStatus) {
		// TODO Auto-generated method stub
		return FosterFamilyMapper.listByRequestStatus(requestStatus);
	}
	
}
