package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.HousingMapper;
import com.house.entity.Housing;
import com.house.entity.HousingText;
import com.house.service.HousingService;

public class HousingServiceImpl implements HousingService{
	
	@Autowired
	private HousingMapper housingMapper;

	@Override
	public int deleteByPrimaryKey(Integer housingId) {
		// TODO Auto-generated method stub
		return housingMapper.deleteByPrimaryKey(housingId);
	}

	@Override
	public int insert(Housing record) {
		// TODO Auto-generated method stub
		return housingMapper.insert(record);
	}

	@Override
	public int insertSelective(Housing record) {
		// TODO Auto-generated method stub
		return housingMapper.insertSelective(record);
	}

	@Override
	public Housing selectByPrimaryKey(Integer housingId) {
		// TODO Auto-generated method stub
		return housingMapper.selectByPrimaryKey(housingId);
	}

	@Override
	public int updateByPrimaryKeySelective(Housing record) {
		// TODO Auto-generated method stub
		return housingMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Housing record) {
		// TODO Auto-generated method stub
		return housingMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Housing> listByState() {
		// TODO Auto-generated method stub
		return housingMapper.listByState();
	}

	@Override
	public List<Housing> listByStateAndHT(HousingText housingText) {
		// TODO Auto-generated method stub
		return housingMapper.listByStateAndHT(housingText);
	}

	@Override
	public List<Housing> listByStateAndThanPrice(HousingText housingText) {
		// TODO Auto-generated method stub
		return housingMapper.listByStateAndThanPrice(housingText);
	}

	@Override
	public List<Housing> listByStateAndlessPrice(HousingText housingText) {
		// TODO Auto-generated method stub
		return housingMapper.listByStateAndlessPrice(housingText);
	}

	@Override
	public List<Housing> searchByTitleAndAddress(String searchText) {
		// TODO Auto-generated method stub
		return housingMapper.searchByTitleAndAddress(searchText);
	}

	@Override
	public List<Housing> selectByHousekeeperId(Integer housekeeperId) {
		// TODO Auto-generated method stub
		return housingMapper.selectByHousekeeperId(housekeeperId);
	}

	@Override
	public List<Housing> listByStateCheck() {
		// TODO Auto-generated method stub
		return housingMapper.listByStateCheck();
	}

}
