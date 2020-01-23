package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IDraftDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IDraftService;
import qqmail.service.IInboxService;

public class IDraftServiceImpl implements IDraftService{
	
	private IDraftDao draftDao;
	

	public void setDraftDao(IDraftDao draftDao) {
		this.draftDao = draftDao;
	}

	public List<MailPro> readAll_Draft(String draft,int send_id,int begin,int end) {
		List<MailPro> list = draftDao.readAll_Draft(draft,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Draft_Count(String draft,int send_id) {
		List<MailPro> list = draftDao.readAll_Draft_Count(draft, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = draftDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		draftDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		draftDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		draftDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		draftDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		draftDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_DraftPro(String draft, int send_id) {
		List<MailPro> list2 = draftDao.readAll_DraftPro(draft, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		draftDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Draft_ById(String draft, int accept_id, int time) {
		MailPro mailPro = draftDao.readAll_Draft_ById(draft, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		draftDao.updateInbox(lnbox, id);
		
	}



	



	
	
}
