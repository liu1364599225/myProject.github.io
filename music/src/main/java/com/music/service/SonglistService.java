package com.music.service;

import java.util.List;

import com.music.entity.Songlist;
import com.music.entity.SonglistAndSong;

public interface SonglistService {
    int deleteByPrimaryKey(Integer songlistId);

    int insert(Songlist record);

    int insertSelective(Songlist record);

    Songlist selectByPrimaryKey(Integer songlistId);
    
    SonglistAndSong selectById(Integer songlistId);
    
    List<Songlist> listAllByUserId(Integer userId);
    
    List<SonglistAndSong> selectAll();
    
    int updateByPrimaryKeySelective(Songlist record);

    int updateByPrimaryKeyWithBLOBs(Songlist record);

    int updateByPrimaryKey(Songlist record);
}