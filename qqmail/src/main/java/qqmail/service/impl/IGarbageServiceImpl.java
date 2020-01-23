package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IGarbageDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IGarbageService;
import qqmail.service.IInboxService;

public class IGarbageServiceImpl implements IGarbageService{
	
	private IGarbageDao garbageDao;

	public void setGarbageDao(IGarbageDao garbageDao) {
		this.garbageDao = garbageDao;
	}

	public List<MailPro> readAll_Garbage(String garbage,int send_id,int begin,int end) {
		List<MailPro> list = garbageDao.readAll_Garbage(garbage,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Garbage_Count(String garbage,int send_id) {
		List<MailPro> list = garbageDao.readAll_Garbage_Count(garbage, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = garbageDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		garbageDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		garbageDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		garbageDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		garbageDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		garbageDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_GarbagePro(String garbage, int send_id) {
		List<MailPro> list2 = garbageDao.readAll_GarbagePro(garbage, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		garbageDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Garbage_ById(String garbage, int accept_id, int time) {
		MailPro mailPro = garbageDao.readAll_Garbage_ById(garbage, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		garbageDao.updateInbox(lnbox, id);
		
	}


	
}
