package qqmail.service;

import java.util.List;
//事件的service层
import qqmail.entry.Event;

public interface IEventService {
	     //查询一个用户的所有event
		 public List<Event> readAllByMaster(int master);
		 
		 //创建一个event返回其主键值
		 public void createEvent(Event event);
		 
		 //修改一个event
		 public void updateEvent(Event event);
		 
		 //删除一个event
		 public void deleteEvent(int eid);
}
