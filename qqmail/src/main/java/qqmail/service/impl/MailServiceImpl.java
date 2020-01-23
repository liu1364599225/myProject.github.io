package qqmail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IMailDao;
import qqmail.entry.Mail;
import qqmail.service.IMailService;

public class MailServiceImpl implements IMailService{
	@Autowired
	private IMailDao dao;
	
	public void setDao(IMailDao dao) {
		this.dao = dao;
	}

//插入数据到邮件表
	public void insert(Mail mail) {
		dao.insert(mail);
		
	}
}
