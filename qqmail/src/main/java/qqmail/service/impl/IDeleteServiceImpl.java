package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IDeleteDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IDeleteService;
import qqmail.service.IInboxService;

public class IDeleteServiceImpl implements IDeleteService{
	
	private IDeleteDao deleteDao;
	
	



	public void setDeleteDao(IDeleteDao deleteDao) {
		this.deleteDao = deleteDao;
	}

	public List<MailPro> readAll_Delete(String delete,int send_id,int begin,int end) {
		List<MailPro> list = deleteDao.readAll_Delete(delete,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Delete_Count(String delete,int send_id) {
		List<MailPro> list = deleteDao.readAll_Delete_Count(delete, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = deleteDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		deleteDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		deleteDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		deleteDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		deleteDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		deleteDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_DeletePro(String delete, int send_id) {
		List<MailPro> list2 = deleteDao.readAll_DeletePro(delete, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		deleteDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Delete_ById(String delete, int accept_id, int time) {
		MailPro mailPro = deleteDao.readAll_Delete_ById(delete, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		deleteDao.updateInbox(lnbox, id);
		
	}



	



	
	
}
