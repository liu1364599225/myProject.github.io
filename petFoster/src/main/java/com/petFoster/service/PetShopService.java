package com.petFoster.service;

import java.util.List;

import com.petFoster.domain.PetShop;

public interface PetShopService {
	int deleteByPrimaryKey(Long psId);

    int insert(PetShop record);

    int insertSelective(PetShop record);

    PetShop selectByPrimaryKey(Long psId);

    int updateByPrimaryKeySelective(PetShop record);

    int updateByPrimaryKey(PetShop record);
    
    List<PetShop> listByAll();
    
    List<PetShop> listByRequestStatus(String requestStatus);
    
    PetShop listByAccount(String accountName);
}
