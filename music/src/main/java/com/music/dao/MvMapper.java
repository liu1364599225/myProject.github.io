package com.music.dao;

import java.util.List;

import com.music.entity.Mv;
import com.music.entity.MvAndSinger;

public interface MvMapper {
    int deleteByPrimaryKey(Integer mvId);

    int insert(Mv record);

    int insertSelective(Mv record);

    Mv selectByPrimaryKey(Integer mvId);

    List<MvAndSinger> selectAll();
    
    int updateByPrimaryKeySelective(Mv record);

    int updateByPrimaryKey(Mv record);
}