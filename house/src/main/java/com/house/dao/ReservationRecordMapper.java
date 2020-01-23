package com.house.dao;

import java.util.List;

import com.house.entity.ReservationRecord;

public interface ReservationRecordMapper {
    int deleteByPrimaryKey(Integer reservationrecordId);

    int insert(ReservationRecord record);

    int insertSelective(ReservationRecord record);

    ReservationRecord selectByPrimaryKey(Integer reservationrecordId);

    int updateByPrimaryKeySelective(ReservationRecord record);

    int updateByPrimaryKey(ReservationRecord record);
    
    
	ReservationRecord selectByOrderState(Integer userId, Integer housingId);

	ReservationRecord selectByUserIdAndHousingId(Integer userId, Integer housingId);

	List<ReservationRecord> selectByUserId(Integer userId);

	List<ReservationRecord> listByAll();
	
	List<ReservationRecord> selectByLookTime();
	
	
	List<ReservationRecord> selectByHkId(Integer housekeeperId);


}