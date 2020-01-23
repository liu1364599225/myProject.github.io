package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.HouseMatingMapper;
import com.house.entity.HouseMating;
import com.house.service.HouseMatingService;

public class HouseMatingServiceImpl implements HouseMatingService{
	
	@Autowired
	private HouseMatingMapper houseMatingMapper;

	@Override
	public int deleteByPrimaryKey(Integer housematingId) {
		// TODO Auto-generated method stub
		return houseMatingMapper.deleteByPrimaryKey(housematingId);
	}

	@Override
	public int insert(HouseMating record) {
		// TODO Auto-generated method stub
		return houseMatingMapper.insert(record);
	}

	@Override
	public int insertSelective(HouseMating record) {
		// TODO Auto-generated method stub
		return houseMatingMapper.insertSelective(record);
	}

	@Override
	public HouseMating selectByPrimaryKey(Integer housematingId) {
		// TODO Auto-generated method stub
		return houseMatingMapper.selectByPrimaryKey(housematingId);
	}

	@Override
	public int updateByPrimaryKeySelective(HouseMating record) {
		// TODO Auto-generated method stub
		return houseMatingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HouseMating record) {
		// TODO Auto-generated method stub
		return houseMatingMapper.updateByPrimaryKey(record);
	}

	@Override
	public HouseMating selectByHousingId(Integer housingId) {
		// TODO Auto-generated method stub
		return houseMatingMapper.selectByHousingId(housingId);
	}

	@Override
	public int updateByHousingId(HouseMating record) {
		// TODO Auto-generated method stub
		return houseMatingMapper.updateByHousingId(record);
	}

}
