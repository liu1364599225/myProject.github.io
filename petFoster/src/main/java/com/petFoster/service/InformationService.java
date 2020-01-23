package com.petFoster.service;

import com.petFoster.domain.Information;

public interface InformationService {
	int deleteByPrimaryKey(Long iId);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Long iId);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);

	Information selectByFosterplaceidAndFosterstyle(Long fId, String string);

	void deleteByFosterplaceidAndFosterStyle(Long psId, String fosterStyle);
}
