package qqmail.service;

import java.util.List;

import qqmail.entry.MyFile;


public interface IFileService {
	//向数据库中加入新的文档
    public void createFile(MyFile file);
 
    //查询一个用户下面所有的在线文档
    public List<MyFile> readAllFileById(int userId);
    
    //根据id删除一个文件
	public void deleteByFileId(int id);
}
