package com.petFoster.dao;

import java.util.List;

import com.petFoster.domain.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long oId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long oId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> listByRequestStatus(String requestStatus1,String requestStatus2,String requestStatus3);
    
    List<Order> listByOneRequestStatus(String requestStatus,String oFosterstyle,Long oFosterplaceid);
    
    List<Order> listBy1RequestStatus(String requestStatus);

    List<Order> listByfuId(Long fuId);
    
    List<Order> listByoFosterplaceid(Long oFosterplaceid,String oFosterstyle);
    
    List<Order> listByAll();
    
    List<Order> listBypId(Long pId);
    
    List<Long> listByRefuse(Long uId);
    
    void deleteByfosterPlaceIdAndfosterStyle(Long placeId,String style);
}