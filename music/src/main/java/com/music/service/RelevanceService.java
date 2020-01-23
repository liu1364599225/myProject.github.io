package com.music.service;

import java.util.List;

import com.music.entity.Relevance;

public interface RelevanceService {
    int deleteByPrimaryKey(Integer relevanceId);

    int insert(Relevance record);

    int insertSelective(Relevance record);

    Relevance selectByPrimaryKey(Integer relevanceId);

    int updateByPrimaryKeySelective(Relevance record);

    int updateByPrimaryKey(Relevance record);
    
    //通过歌单编号查询歌单对应的所有歌曲
    List<Relevance> listAllBySonglistId(Integer songlistId);
}