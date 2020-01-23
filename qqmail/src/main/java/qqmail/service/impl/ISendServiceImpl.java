package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.ISendDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IInboxService;
import qqmail.service.ISendService;

public class ISendServiceImpl implements ISendService{
	
	private ISendDao sendDao;
	

	public void setSendDao(ISendDao sendDao) {
		this.sendDao = sendDao;
	}

	public List<MailPro> readAll_Send(String send,int send_id,int begin,int end) {
		List<MailPro> list = sendDao.readAll_Send(send,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Send_Count(String send,int send_id) {
		List<MailPro> list = sendDao.readAll_Send_Count(send, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = sendDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		sendDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		sendDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		sendDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		sendDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		sendDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_SendPro(String send, int send_id) {
		List<MailPro> list2 = sendDao.readAll_SendPro(send, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		sendDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Send_ById(String send, int accept_id, int time) {
		MailPro mailPro = sendDao.readAll_Send_ById(send, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		sendDao.updateInbox(lnbox, id);
	}


	
}
