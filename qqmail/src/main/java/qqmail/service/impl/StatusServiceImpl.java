package qqmail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IStatusDao;
import qqmail.entry.Status;
import qqmail.service.IStatusService;

public class StatusServiceImpl implements IStatusService{
	
	@Autowired
	private IStatusDao dao;
	
	public void setDao(IStatusDao dao) {
		this.dao = dao;
	}

	public void insertReturnId(Status status) {
		// TODO Auto-generated method stub
		dao.insertReturnId(status);
		
	}

}
