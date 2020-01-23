package com.house.service;

import java.util.List;

import com.house.entity.Comment;

public interface CommentService {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 通过房源id查询出该房源的所有房源评论
     */
	List<Comment> selectByHousingId(Integer housingId);
	
}
