package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IFileDao;
import qqmail.entry.MyFile;
import qqmail.service.IFileService;

public class FileServiceImpl implements IFileService{
	@Autowired
	private IFileDao dao;
	
	public void createFile(MyFile file) {
		dao.createFile(file);
	}

	public List<MyFile> readAllFileById(int userId) {
		return dao.readAllFileById(userId);
	}

	public void deleteByFileId(int id) {
		dao.deleteByFileId(id);
	}

}
