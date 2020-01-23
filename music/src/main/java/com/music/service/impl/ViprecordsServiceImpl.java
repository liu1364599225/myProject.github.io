package com.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.ViprecordsMapper;
import com.music.entity.Viprecords;
import com.music.service.ViprecordsService;

public class ViprecordsServiceImpl implements ViprecordsService{
	@Autowired
	private ViprecordsMapper viprecordsMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer viprecordsId) {
		// TODO Auto-generated method stub
		return viprecordsMapper.deleteByPrimaryKey(viprecordsId);
	}

	@Override
	public int insert(Viprecords record) {
		// TODO Auto-generated method stub
		return viprecordsMapper.insert(record);
	}

	@Override
	public int insertSelective(Viprecords record) {
		// TODO Auto-generated method stub
		return viprecordsMapper.insertSelective(record);
	}

	@Override
	public Viprecords selectByPrimaryKey(Integer viprecordsId) {
		// TODO Auto-generated method stub
		return viprecordsMapper.selectByPrimaryKey(viprecordsId);
	}

	@Override
	public int updateByPrimaryKeySelective(Viprecords record) {
		// TODO Auto-generated method stub
		return viprecordsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Viprecords record) {
		// TODO Auto-generated method stub
		return viprecordsMapper.updateByPrimaryKey(record);
	}

}
