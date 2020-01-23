package com.music.dao;

import com.music.entity.Viprecords;

public interface ViprecordsMapper {
    int deleteByPrimaryKey(Integer viprecordsId);

    int insert(Viprecords record);

    int insertSelective(Viprecords record);

    Viprecords selectByPrimaryKey(Integer viprecordsId);

    int updateByPrimaryKeySelective(Viprecords record);

    int updateByPrimaryKey(Viprecords record);
}