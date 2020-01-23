package com.music.service;

import java.util.List;

import com.music.entity.Singer;

public interface SingerService {
    int deleteByPrimaryKey(Integer singerId);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer singerId);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKeyWithBLOBs(Singer record);

    int updateByPrimaryKey(Singer record);

    /**
     * @author 刘波
     * @param listByAll()查询所有数据;
     */
    List<Singer> listByAll();
}