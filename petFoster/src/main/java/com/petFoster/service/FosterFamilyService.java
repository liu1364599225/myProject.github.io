package com.petFoster.service;

import java.util.List;

import com.petFoster.domain.FosterFamily;

public interface FosterFamilyService {
	int deleteByPrimaryKey(Long fId);

    int insert(FosterFamily record);

    int insertSelective(FosterFamily record);

    FosterFamily selectByPrimaryKey(Long fId);

    int updateByPrimaryKeySelective(FosterFamily record);

    int updateByPrimaryKey(FosterFamily record);
    
    List<FosterFamily> listByAll();
    
    List<FosterFamily> listByRequestStatus(String requestStatus);
    
    FosterFamily listByAccount(String accountName);
}
