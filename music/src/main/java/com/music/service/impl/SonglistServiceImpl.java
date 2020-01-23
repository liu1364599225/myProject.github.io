package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.SonglistMapper;
import com.music.entity.Songlist;
import com.music.entity.SonglistAndSong;
import com.music.service.SonglistService;

public class SonglistServiceImpl implements SonglistService{
	@Autowired
	private SonglistMapper songlistMapper;
	
	
	public int deleteByPrimaryKey(Integer songlistId) {
		// TODO Auto-generated method stub
		return songlistMapper.deleteByPrimaryKey(songlistId);
	}

	
	public int insert(Songlist record) {
		// TODO Auto-generated method stub
		return songlistMapper.insert(record);
	}

	
	public int insertSelective(Songlist record) {
		// TODO Auto-generated method stub
		return songlistMapper.insertSelective(record);
	}

	
	public Songlist selectByPrimaryKey(Integer songlistId) {
		// TODO Auto-generated method stub
		return songlistMapper.selectByPrimaryKey(songlistId);
	}

	
	public int updateByPrimaryKeySelective(Songlist record) {
		// TODO Auto-generated method stub
		return songlistMapper.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKeyWithBLOBs(Songlist record) {
		// TODO Auto-generated method stub
		return songlistMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	
	public int updateByPrimaryKey(Songlist record) {
		// TODO Auto-generated method stub
		return songlistMapper.updateByPrimaryKey(record);
	}


	public SonglistAndSong selectById(Integer songlistId) {
		// TODO Auto-generated method stub
		return songlistMapper.selectById(songlistId);
	}


	public List<SonglistAndSong> selectAll() {
		// TODO Auto-generated method stub
		return songlistMapper.selectAll();
	}


	@Override
	public List<Songlist> listAllByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return songlistMapper.listAllByUserId(userId);
	}

}
