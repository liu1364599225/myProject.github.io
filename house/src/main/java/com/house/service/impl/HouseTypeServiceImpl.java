package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.HouseTypeMapper;
import com.house.entity.HouseType;
import com.house.service.HouseTypeService;

public class HouseTypeServiceImpl implements HouseTypeService{
	
	@Autowired
	private HouseTypeMapper houseTypeMapper;

	@Override
	public int deleteByPrimaryKey(Integer housetypeId) {
		// TODO Auto-generated method stub
		return houseTypeMapper.deleteByPrimaryKey(housetypeId);
	}

	@Override
	public int insert(HouseType record) {
		// TODO Auto-generated method stub
		return houseTypeMapper.insert(record);
	}

	@Override
	public int insertSelective(HouseType record) {
		// TODO Auto-generated method stub
		return houseTypeMapper.insertSelective(record);
	}

	@Override
	public HouseType selectByPrimaryKey(Integer housetypeId) {
		// TODO Auto-generated method stub
		return houseTypeMapper.selectByPrimaryKey(housetypeId);
	}

	@Override
	public int updateByPrimaryKeySelective(HouseType record) {
		// TODO Auto-generated method stub
		return houseTypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HouseType record) {
		// TODO Auto-generated method stub
		return houseTypeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<HouseType> listByAll() {
		// TODO Auto-generated method stub
		return houseTypeMapper.listByAll();
	}

	@Override
	public HouseType selectByHouseTypeName(String houseType) {
		// TODO Auto-generated method stub
		return houseTypeMapper.selectByHouseTypeName(houseType);
	}

}
