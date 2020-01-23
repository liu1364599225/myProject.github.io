package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.INotepaperDao;
import qqmail.entry.Notepaper;
import qqmail.service.INotepaperService;

public class NotepaperServiceImpl implements INotepaperService{
	@Autowired
	private INotepaperDao dao;
	

	public void setDao(INotepaperDao dao) {
		this.dao = dao;
	}

	public List<Notepaper> listByAll() {
		// TODO Auto-generated method stub
		return dao.listByAll();
	}

	public List<Notepaper> listByOnePage(int start, int end) {
		// TODO Auto-generated method stub
		return dao.listByOnePage(start, end);
	}

	public void insert(Notepaper notepaper) {
		// TODO Auto-generated method stub
		dao.insert(notepaper);
	}

	public Notepaper selectById(int notepaper_id) {
		// TODO Auto-generated method stub
		return dao.selectById(notepaper_id);
	}

}
