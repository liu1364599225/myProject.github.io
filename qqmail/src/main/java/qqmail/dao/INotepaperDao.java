package qqmail.dao;

import java.util.List;

import qqmail.entry.Notepaper;

public interface INotepaperDao {

	//插入新的信纸
	public void insert(Notepaper notepaper);
	
	//查出信纸表所有数据
	public List<Notepaper> listByAll();
	
	//查出信纸表指定条数的数据
	public List<Notepaper> listByOnePage(int start,int end);
	
	//通过信纸id查出对应数据
	public Notepaper selectById(int notepaper_id);
}
