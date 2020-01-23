package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.SingerMapper;
import com.music.entity.Singer;
import com.music.service.SingerService;

public class SingerServiceImpl implements SingerService{
	@Autowired
	private SingerMapper singerMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer singerId) {
		// TODO Auto-generated method stub
		return singerMapper.deleteByPrimaryKey(singerId);
	}

	@Override
	public int insert(Singer record) {
		// TODO Auto-generated method stub
		return singerMapper.insert(record);
	}

	@Override
	public int insertSelective(Singer record) {
		// TODO Auto-generated method stub
		return singerMapper.insertSelective(record);
	}

	@Override
	public Singer selectByPrimaryKey(Integer singerId) {
		// TODO Auto-generated method stub
		return singerMapper.selectByPrimaryKey(singerId);
	}

	@Override
	public int updateByPrimaryKeySelective(Singer record) {
		// TODO Auto-generated method stub
		return singerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Singer record) {
		// TODO Auto-generated method stub
		return singerMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Singer record) {
		// TODO Auto-generated method stub
		return singerMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Singer> listByAll() {
		// TODO Auto-generated method stub
		return singerMapper.listByAll();
	}

}
