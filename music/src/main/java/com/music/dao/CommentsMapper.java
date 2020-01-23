package com.music.dao;

import java.util.List;

import com.music.entity.Comments;
import com.music.entity.UsersAndComments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer commentsId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer commentsId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);

	/**
	 * 通过歌曲id查询对应歌曲的所有评论及用户姓名和头像
     * @param songId 歌曲编号
     * @return 用户和评论对象集合
	 */
    List<UsersAndComments> selectBySongId(Integer songId);
}