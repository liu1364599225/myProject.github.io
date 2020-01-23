package com.music.dao;

import com.music.entity.Songtype;

public interface SongtypeMapper {
    int deleteByPrimaryKey(Integer songtypeId);

    int insert(Songtype record);

    int insertSelective(Songtype record);

    Songtype selectByPrimaryKey(Integer songtypeId);

    int updateByPrimaryKeySelective(Songtype record);

    int updateByPrimaryKey(Songtype record);
}