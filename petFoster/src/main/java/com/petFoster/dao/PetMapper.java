package com.petFoster.dao;

import java.util.List;

import com.petFoster.domain.Pet;

public interface PetMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Long pId);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);
    
    List<Pet> listByAll();
    
    List<Pet> selectByfuId(long fuId);
    
    List<Pet> listByPetNameAndFuId(long fuId,String pPetname);
}