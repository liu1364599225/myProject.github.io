package com.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.HouseKeeperMapper;
import com.house.entity.HouseKeeper;
import com.house.service.HouseKeeperService;

public class HouseKeeperServiceImpl implements HouseKeeperService{

	@Autowired
	private HouseKeeperMapper houseKeeperMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer housekeeperId) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.deleteByPrimaryKey(housekeeperId);
	}

	@Override
	public int insert(HouseKeeper record) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.insert(record);
	}

	@Override
	public int insertSelective(HouseKeeper record) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.insertSelective(record);
	}

	@Override
	public HouseKeeper selectByPrimaryKey(Integer housekeeperId) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.selectByPrimaryKey(housekeeperId);
	}

	@Override
	public int updateByPrimaryKeySelective(HouseKeeper record) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HouseKeeper record) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.updateByPrimaryKey(record);
	}

	@Override
	public HouseKeeper selectByAccount(String houseKeeperAccount) {
		// TODO Auto-generated method stub
		return houseKeeperMapper.selectByAccount(houseKeeperAccount);
	}

}
