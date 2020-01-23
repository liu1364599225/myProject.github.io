package com.house.fifter;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.ReservationRecord;
import com.house.service.ReservationRecordService;


public class LoginFifter implements HandlerInterceptor{

	@Autowired
	private ReservationRecordService reservationRecordService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		List<ReservationRecord> rRecordList = reservationRecordService.selectByLookTime();
		for(ReservationRecord record : rRecordList){
			record.setReservationrecordState("已失效");
			reservationRecordService.updateByPrimaryKeySelective(record);
		}
		
		
		/*if(null == request.getSession().getAttribute("houseKeeperAccount")){
			StringBuffer url = request.getRequestURL();
			String str = url.substring(url.lastIndexOf("/"), url.length());
			if(str.equals("/indexPage.fw") || str.equals("/valicode.fw")
					|| str.equals("/index.fw") || str.equals("/userExit.fw")
					|| str.equals("/loginPage.fw") || str.equals("/login.fw")){
				return true;
			}else{
				response.sendRedirect(request.getContextPath()+"/loginPage.fw");
				return false;
			}
		}*/
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
