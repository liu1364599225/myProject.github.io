package com.petFoster.dao;

import java.util.List;

import com.petFoster.domain.FosterUser;

public interface FosterUserMapper {
    int deleteByPrimaryKey(Long fuId);

    int insert(FosterUser record);

    int insertSelective(FosterUser record);

    FosterUser selectByPrimaryKey(Long fuId);

    int updateByPrimaryKeySelective(FosterUser record);

    int updateByPrimaryKey(FosterUser record);
    
    List<FosterUser> listByAll();
    
    List<FosterUser> listByRequestStatus(String requestStatus);
    
    FosterUser listByAccount(String accountName);
}