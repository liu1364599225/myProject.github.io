package com.music.service;

import java.util.List;

import com.music.entity.Mv;
import com.music.entity.MvAndSinger;

public interface MvService {
	int deleteByPrimaryKey(Integer mvId);

    int insert(Mv record);

    int insertSelective(Mv record);

    Mv selectByPrimaryKey(Integer mvId);

    List<MvAndSinger> selectAll();
    
    int updateByPrimaryKeySelective(Mv record);

    int updateByPrimaryKey(Mv record);
}
