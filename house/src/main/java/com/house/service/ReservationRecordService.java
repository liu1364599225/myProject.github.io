package com.house.service;

import java.util.List;

import com.house.entity.ReservationRecord;

public interface ReservationRecordService {
	int deleteByPrimaryKey(Integer reservationrecordId);

    int insert(ReservationRecord record);

    int insertSelective(ReservationRecord record);

    ReservationRecord selectByPrimaryKey(Integer reservationrecordId);

    int updateByPrimaryKeySelective(ReservationRecord record);

    int updateByPrimaryKey(ReservationRecord record);

    /**
     * 
     * @param userId
     * @param housingId
     * 通过用户id、房源id、预约状态、预约时间是否小于当前时间查询记录表是否已有预约记录
     */
	ReservationRecord selectByOrderState(Integer userId, Integer housingId);

    /**
     * 
     * @param userId
     * @param housingId
     * 通过用户id、房源id查询记录表是否已有预约记录
     */
	ReservationRecord selectByUserIdAndHousingId(Integer userId, Integer housingId);

	
	/**
     * 
     * @param userId
     * 通过用户id查询出该用户的所有预约记录
     */
	List<ReservationRecord> selectByUserId(Integer userId);

	/**
	 * 
	 * 查询出所有的预约记录
	 */
	List<ReservationRecord> listByAll();

	/**
	 * 
	 * 查询出所有预约时间小于当前时间的预约记录
	 */
	List<ReservationRecord> selectByLookTime();

	/**
     * 
     * @param housekeeperId
     * 通过房管员id查询出该用户的所有预约记录
     */
	List<ReservationRecord> selectByHkId(Integer housekeeperId);
}
