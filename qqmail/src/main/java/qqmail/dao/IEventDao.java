package qqmail.dao;

import java.util.List;

import qqmail.entry.Event;

//用于事件的dao类接口
public interface IEventDao {
     //查询一个用户的所有event
	 public List<Event> readAllByMaster(int master);
	 
	 //创建一个event返回其主键值
	 /**
	  * 特别说明，这里返回一个主键值并不是说要你把createEvent的方法返回值设为int
	  * 而且是在插入完数据后event.getEid()应该为主键值这里是个坑
	  * @param event
	  */
	 public void createEvent(Event event);
	 
	 //修改一个event
	 public void updateEvent(Event event);
	 
	 //删除一个event
	 public void deleteEvent(int eid);
}
