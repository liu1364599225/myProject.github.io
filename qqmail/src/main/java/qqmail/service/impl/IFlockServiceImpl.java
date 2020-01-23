package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IFlockDao;
import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.service.IFlockService;
import qqmail.service.IInboxService;

public class IFlockServiceImpl implements IFlockService{
	
	private IFlockDao flockDao; 
	
	


	public void setFlockDao(IFlockDao flockDao) {
		this.flockDao = flockDao;
	}

	public List<MailPro> readAll_Flock(String flock,int send_id,int begin,int end) {
		List<MailPro> list = flockDao.readAll_Flock(flock,send_id,begin,end);
		System.out.println(list);
		return list;
	}
	
	public List<MailPro> readAll_Flock_Count(String flock,int send_id) {
		List<MailPro> list = flockDao.readAll_Flock_Count(flock, send_id);
		System.out.println(list);
		return list;
	}



	public Status readBySendId(int senId,int time) {
		Status status = flockDao.readBySendId(senId,time);
		return status;
	}



	public void update(String afind,String unfind,int id) {
		flockDao.update(afind,unfind,id);
	}



	public void updateStar(String star, int id) {
		flockDao.updateStar(star, id);
	}



	public void updateDeletes(String deletes, int id) {
		flockDao.updateDeletes(deletes, id);
	}



	public void deleteTrue(int statusId) {
		flockDao.deleteTrue(statusId);
		
	}



	public void updateAsend(String asend, String unsend, int id) {
		flockDao.updateAsend(asend, unsend, id);
	}



	public List<MailPro> readAll_FlockPro(String flock, int send_id) {
		List<MailPro> list2 = flockDao.readAll_FlockPro(flock, send_id);
		return list2;
	}



	public void updateReport(String deletes, int id) {
		flockDao.updateReport(deletes, id);
		
	}



	public MailPro readAll_Flock_ById(String flock, int accept_id, int time) {
		MailPro mailPro = flockDao.readAll_Flock_ById(flock, accept_id, time);
		return mailPro;
	}

	public void updateInbox(String lnbox, int id) {
		flockDao.updateInbox(lnbox, id);
		
	}

//	public List<Linkman_group> readAll_Linkman(int accept_id) {
//		flockDao.readAll_Linkman(accept_id);
//		return null;
//	}



	



	
	
}
