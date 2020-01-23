package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.SpecialMapper;
import com.music.entity.Special;
import com.music.service.SpecialService;

public class SpecialServiceImpl implements SpecialService{
	@Autowired
	private SpecialMapper specialMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer specialId) {
		// TODO Auto-generated method stub
		return specialMapper.deleteByPrimaryKey(specialId);
	}

	@Override
	public int insert(Special record) {
		// TODO Auto-generated method stub
		return specialMapper.insert(record);
	}

	@Override
	public int insertSelective(Special record) {
		// TODO Auto-generated method stub
		return specialMapper.insertSelective(record);
	}

	@Override
	public Special selectByPrimaryKey(Integer specialId) {
		// TODO Auto-generated method stub
		return specialMapper.selectByPrimaryKey(specialId);
	}

	@Override
	public int updateByPrimaryKeySelective(Special record) {
		// TODO Auto-generated method stub
		return specialMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Special record) {
		// TODO Auto-generated method stub
		return specialMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Special record) {
		// TODO Auto-generated method stub
		return specialMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Special> selectSpecialAll() {
		// TODO Auto-generated method stub
		return specialMapper.selectSpecialAll();
	}

	@Override
	public Special selectByPrimaryKey1(int specialId) {
		// TODO Auto-generated method stub
		return specialMapper.selectByPrimaryKey1(specialId);
	}

}
