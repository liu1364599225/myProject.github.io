package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IInboxDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IInboxService;

public class IInboxServiceImpl implements IInboxService{
	
	private IInboxDao inboxDao;
	
	

	public void setInboxDao(IInboxDao inboxDao) {
		this.inboxDao = inboxDao;
	}



	public List<MailPro> readAll_Inbox(String inbox,int send_id,int begin,int end) {
		List<MailPro> list = inboxDao.readAll_Inbox(inbox,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Inbox_Count(String inbox,int send_id) {
		List<MailPro> list = inboxDao.readAll_Inbox_Count(inbox, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = inboxDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		inboxDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		inboxDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		inboxDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		inboxDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		inboxDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_InboxPro(String inbox, int send_id) {
		List<MailPro> list2 = inboxDao.readAll_InboxPro(inbox, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		inboxDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Inbox_ById(String inbox, int accept_id, int time) {
		MailPro mailPro = inboxDao.readAll_Inbox_ById(inbox, accept_id, time);
		return mailPro;
	}



	



	
	
}
