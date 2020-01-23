package com.house.service;

import com.house.entity.HouseMating;

public interface HouseMatingService {
	int deleteByPrimaryKey(Integer housematingId);

    int insert(HouseMating record);

    int insertSelective(HouseMating record);

    HouseMating selectByPrimaryKey(Integer housematingId);

    int updateByPrimaryKeySelective(HouseMating record);

    int updateByPrimaryKey(HouseMating record);

    
    /**
     * 
     * 通过房源id查询对应房源配套信息
     * 
     */
	HouseMating selectByHousingId(Integer housingId);
	
	/**
	 * 
	 * 通过房源id修改对应房源配套信息
	 */
    int updateByHousingId(HouseMating record);

}
