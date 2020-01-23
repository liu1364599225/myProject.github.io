package com.house.dao;

import java.util.List;

import com.house.entity.Housing;
import com.house.entity.HousingText;

public interface HousingMapper {
    int deleteByPrimaryKey(Integer housingId);

    int insert(Housing record);

    int insertSelective(Housing record);

    Housing selectByPrimaryKey(Integer housingId);

    int updateByPrimaryKeySelective(Housing record);

    int updateByPrimaryKey(Housing record);
    
    
    
    List<Housing> listByState();

	List<Housing> listByStateAndHT(HousingText housingText);
	
	List<Housing> listByStateAndThanPrice(HousingText housingText);

	List<Housing> listByStateAndlessPrice(HousingText housingText);
	
	List<Housing> searchByTitleAndAddress(String searchText);

	List<Housing> selectByHousekeeperId(Integer housekeeperId);
	
	List<Housing> listByStateCheck();

}