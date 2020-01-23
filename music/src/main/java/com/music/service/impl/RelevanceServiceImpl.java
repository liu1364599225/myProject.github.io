package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.RelevanceMapper;
import com.music.entity.Relevance;
import com.music.service.RelevanceService;

public class RelevanceServiceImpl implements RelevanceService{
	@Autowired
	private RelevanceMapper relevanceMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer relevanceId) {
		// TODO Auto-generated method stub
		return relevanceMapper.deleteByPrimaryKey(relevanceId);
	}

	@Override
	public int insert(Relevance record) {
		// TODO Auto-generated method stub
		return relevanceMapper.insert(record);
	}

	@Override
	public int insertSelective(Relevance record) {
		// TODO Auto-generated method stub
		return relevanceMapper.insertSelective(record);
	}

	@Override
	public Relevance selectByPrimaryKey(Integer relevanceId) {
		// TODO Auto-generated method stub
		return relevanceMapper.selectByPrimaryKey(relevanceId);
	}

	@Override
	public int updateByPrimaryKeySelective(Relevance record) {
		// TODO Auto-generated method stub
		return relevanceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Relevance record) {
		// TODO Auto-generated method stub
		return relevanceMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Relevance> listAllBySonglistId(Integer songlistId) {
		// TODO Auto-generated method stub
		return relevanceMapper.listAllBySonglistId(songlistId);
	}

}
