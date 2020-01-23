package com.music.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.music.dao.CommentsMapper;
import com.music.entity.Comments;
import com.music.entity.UsersAndComments;
import com.music.service.CommentsService;

public class CommentsServiceImpl implements CommentsService{
	
	@Autowired
	private CommentsMapper commentsMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer commentsId) {
		// TODO Auto-generated method stub
		return commentsMapper.deleteByPrimaryKey(commentsId);
	}

	@Override
	public int insert(Comments record) {
		// TODO Auto-generated method stub
		return commentsMapper.insert(record);
	}

	@Override
	public int insertSelective(Comments record) {
		// TODO Auto-generated method stub
		return commentsMapper.insertSelective(record);
	}

	@Override
	public Comments selectByPrimaryKey(Integer commentsId) {
		// TODO Auto-generated method stub
		return commentsMapper.selectByPrimaryKey(commentsId);
	}

	@Override
	public int updateByPrimaryKeySelective(Comments record) {
		// TODO Auto-generated method stub
		return commentsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Comments record) {
		// TODO Auto-generated method stub
		return commentsMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Comments record) {
		// TODO Auto-generated method stub
		return commentsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<UsersAndComments> selectBySongId(Integer songId) {
		// TODO Auto-generated method stub
		return commentsMapper.selectBySongId(songId);
	}
	
}
