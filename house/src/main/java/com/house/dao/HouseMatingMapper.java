package com.house.dao;

import com.house.entity.HouseMating;

public interface HouseMatingMapper {
    int deleteByPrimaryKey(Integer housematingId);

    int insert(HouseMating record);

    int insertSelective(HouseMating record);

    HouseMating selectByPrimaryKey(Integer housematingId);

    int updateByPrimaryKeySelective(HouseMating record);
    
    int updateByHousingId(HouseMating record);

    int updateByPrimaryKey(HouseMating record);
    
    
	HouseMating selectByHousingId(Integer housingId);

}