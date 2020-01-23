package com.music.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.SongtypeMapper;
import com.music.entity.Songtype;
import com.music.service.SongtypeService;

public class SongtypeServiceImpl implements SongtypeService{
	@Autowired
	private SongtypeMapper songtypeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer songtypeId) {
		// TODO Auto-generated method stub
		return songtypeMapper.deleteByPrimaryKey(songtypeId);
	}

	@Override
	public int insert(Songtype record) {
		// TODO Auto-generated method stub
		return songtypeMapper.insert(record);
	}

	@Override
	public int insertSelective(Songtype record) {
		// TODO Auto-generated method stub
		return songtypeMapper.insertSelective(record);
	}

	@Override
	public Songtype selectByPrimaryKey(Integer songtypeId) {
		// TODO Auto-generated method stub
		return songtypeMapper.selectByPrimaryKey(songtypeId);
	}

	@Override
	public int updateByPrimaryKeySelective(Songtype record) {
		// TODO Auto-generated method stub
		return songtypeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Songtype record) {
		// TODO Auto-generated method stub
		return songtypeMapper.updateByPrimaryKey(record);
	}

}
