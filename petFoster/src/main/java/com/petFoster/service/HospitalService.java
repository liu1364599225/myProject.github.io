package com.petFoster.service;

import java.util.List;

import com.petFoster.domain.Hospital;

public interface HospitalService {
	int deleteByPrimaryKey(Long hId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Long hId);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
    
    List<Hospital> listByAll();
}
