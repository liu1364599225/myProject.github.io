package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.PetMapper;
import com.petFoster.domain.Pet;
import com.petFoster.service.PetService;

public class PetServiceImpl implements PetService{
	@Autowired
	private PetMapper PetMapper;
	
	public int deleteByPrimaryKey(Long pId) {
		// TODO Auto-generated method stub
		return PetMapper.deleteByPrimaryKey(pId);
	}

	public int insert(Pet record) {
		// TODO Auto-generated method stub
		return PetMapper.insert(record);
	}

	public int insertSelective(Pet record) {
		// TODO Auto-generated method stub
		return PetMapper.insertSelective(record);
	}

	public Pet selectByPrimaryKey(Long pId) {
		// TODO Auto-generated method stub
		return PetMapper.selectByPrimaryKey(pId);
	}

	public int updateByPrimaryKeySelective(Pet record) {
		// TODO Auto-generated method stub
		return PetMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Pet record) {
		// TODO Auto-generated method stub
		return PetMapper.updateByPrimaryKey(record);
	}

	public List<Pet> listByAll() {
		// TODO Auto-generated method stub
		return PetMapper.listByAll();
	}

	public List<Pet> selectByfuId(long fuId) {
		// TODO Auto-generated method stub
		return PetMapper.selectByfuId(fuId);
	}

	public List<Pet> listByPetNameAndFuId(long fuId, String pPetname) {
		// TODO Auto-generated method stub
		return PetMapper.listByPetNameAndFuId(fuId, pPetname);
	}

}
