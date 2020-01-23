package com.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.VipMapper;
import com.music.entity.Vip;
import com.music.service.VipService;

public class VipServiceImpl implements VipService{
	@Autowired
	private VipMapper vipMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer vipId) {
		// TODO Auto-generated method stub
		return vipMapper.deleteByPrimaryKey(vipId);
	}

	@Override
	public int insert(Vip record) {
		// TODO Auto-generated method stub
		return vipMapper.insert(record);
	}

	@Override
	public int insertSelective(Vip record) {
		// TODO Auto-generated method stub
		return vipMapper.insertSelective(record);
	}

	@Override
	public Vip selectByPrimaryKey(Integer vipId) {
		// TODO Auto-generated method stub
		return vipMapper.selectByPrimaryKey(vipId);
	}

	@Override
	public int updateByPrimaryKeySelective(Vip record) {
		// TODO Auto-generated method stub
		return vipMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Vip record) {
		// TODO Auto-generated method stub
		return vipMapper.updateByPrimaryKey(record);
	}

}
