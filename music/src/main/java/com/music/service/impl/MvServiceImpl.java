package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.MvMapper;
import com.music.entity.Mv;
import com.music.entity.MvAndSinger;
import com.music.service.MvService;

public class MvServiceImpl implements MvService{
	@Autowired
	private MvMapper mvMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer mvId) {
		// TODO Auto-generated method stub
		return mvMapper.deleteByPrimaryKey(mvId);
	}

	@Override
	public int insert(Mv record) {
		// TODO Auto-generated method stub
		return mvMapper.insert(record);
	}

	@Override
	public int insertSelective(Mv record) {
		// TODO Auto-generated method stub
		return mvMapper.insertSelective(record);
	}

	@Override
	public Mv selectByPrimaryKey(Integer mvId) {
		// TODO Auto-generated method stub
		return mvMapper.selectByPrimaryKey(mvId);
	}

	@Override
	public int updateByPrimaryKeySelective(Mv record) {
		// TODO Auto-generated method stub
		return mvMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Mv record) {
		// TODO Auto-generated method stub
		return mvMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<MvAndSinger> selectAll() {
		// TODO Auto-generated method stub
		return mvMapper.selectAll();
	}

}
