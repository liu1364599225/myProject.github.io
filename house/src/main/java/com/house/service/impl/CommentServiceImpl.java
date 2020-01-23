package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.CommentMapper;
import com.house.entity.Comment;
import com.house.service.CommentService;

public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public int deleteByPrimaryKey(Integer commentId) {
		// TODO Auto-generated method stub
		return commentMapper.deleteByPrimaryKey(commentId);
	}

	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.insert(record);
	}

	@Override
	public int insertSelective(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.insertSelective(record);
	}

	@Override
	public Comment selectByPrimaryKey(Integer commentId) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(commentId);
	}

	@Override
	public int updateByPrimaryKeySelective(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method stub
		return commentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Comment> selectByHousingId(Integer housingId) {
		// TODO Auto-generated method stub
		return commentMapper.selectByHousingId(housingId);
	}

}
