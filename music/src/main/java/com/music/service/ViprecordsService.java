package com.music.service;

import com.music.entity.Viprecords;

public interface ViprecordsService {
    int deleteByPrimaryKey(Integer viprecordsId);

    int insert(Viprecords record);

    int insertSelective(Viprecords record);

    Viprecords selectByPrimaryKey(Integer viprecordsId);

    int updateByPrimaryKeySelective(Viprecords record);

    int updateByPrimaryKey(Viprecords record);
}