package com.music.service;

import java.util.List;

import com.music.entity.Special;

public interface SpecialService {
    int deleteByPrimaryKey(Integer specialId);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Integer specialId);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKeyWithBLOBs(Special record);

    int updateByPrimaryKey(Special record);
    
    /**
     * 查询所有专辑
     * 李庭辉
     * @return 专辑集合（包含歌手名）
     */
	List<Special> selectSpecialAll();
	/**
	 * 李庭辉
	 * @param specialId 用户编号
	 * @return 连歌手表查询，返回包含歌手名的专辑信息
	 */
	Special selectByPrimaryKey1(int specialId);
}