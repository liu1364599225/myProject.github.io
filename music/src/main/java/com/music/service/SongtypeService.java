package com.music.service;

import com.music.entity.Songtype;

public interface SongtypeService {
    int deleteByPrimaryKey(Integer songtypeId);

    int insert(Songtype record);

    int insertSelective(Songtype record);

    Songtype selectByPrimaryKey(Integer songtypeId);

    int updateByPrimaryKeySelective(Songtype record);

    int updateByPrimaryKey(Songtype record);
}