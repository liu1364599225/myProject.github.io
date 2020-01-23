package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IStarDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IStarService;

public class IStarServiceImpl implements IStarService{
	
	private IStarDao starDao;
	

	public void setStarDao(IStarDao starDao) {
		this.starDao = starDao;
	}

	public List<MailPro> readAll_Star(String star,int send_id,int begin,int end) {
		List<MailPro> list = starDao.readAll_Star(star,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Star_Count(String star,int send_id) {
		List<MailPro> list = starDao.readAll_Star_Count(star, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = starDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		starDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		starDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		starDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		starDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		starDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_StarPro(String inbox, int send_id) {
		List<MailPro> list2 = starDao.readAll_StarPro(inbox, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		starDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Star_ById(String inbox, int accept_id, int time) {
		MailPro mailPro = starDao.readAll_Star_ById(inbox, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		starDao.updateInbox(lnbox, id);
		
	}




	



	
	
}
