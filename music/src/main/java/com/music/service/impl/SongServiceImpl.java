package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.SongMapper;
import com.music.entity.Song;
import com.music.entity.SongDetails;
import com.music.service.SongService;

public class SongServiceImpl implements SongService{
	@Autowired
	private SongMapper songMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer songId) {
		// TODO Auto-generated method stub
		return songMapper.deleteByPrimaryKey(songId);
	}

	@Override
	public int insert(Song record) {
		// TODO Auto-generated method stub
		return songMapper.insert(record);
	}

	@Override
	public int insertSelective(Song record) {
		// TODO Auto-generated method stub
		return songMapper.insertSelective(record);
	}

	@Override
	public Song selectByPrimaryKey(Integer songId) {
		// TODO Auto-generated method stub
		return songMapper.selectByPrimaryKey(songId);
	}

	@Override
	public int updateByPrimaryKeySelective(Song record) {
		// TODO Auto-generated method stub
		return songMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Song record) {
		// TODO Auto-generated method stub
		return songMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Song> selectBySingerId(Integer singerId) {
		// TODO Auto-generated method stub
		return songMapper.selectBySingerId(singerId);
	}

	@Override
	public List<Song> findBySpecialId(Integer specialId) {
		// TODO Auto-generated method stub
		return songMapper.findBySpecialId(specialId);
	}

	@Override
	public SongDetails selectDetails(Integer songId) {
		// TODO Auto-generated method stub
		return songMapper.selectDetails(songId);
	}

}
