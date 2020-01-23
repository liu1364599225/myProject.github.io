package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IEventDao;
import qqmail.entry.Event;
import qqmail.service.IEventService;

public class EventServiceImpl implements IEventService{
	@Autowired
    private IEventDao dao;//自动创建dao接口类然后自动注入
	
	//根据一个用户id查找所有的事件
	public List<Event> readAllByMaster(int master) {
		return dao.readAllByMaster(master);
	}

	//创建一个事件并且返回主键值
	public void createEvent(Event event) {
		dao.createEvent(event);
	}

	//修改一个事件的title
	public void updateEvent(Event event) {
		dao.updateEvent(event);
	}

	//根据一个事件的id删除一个事件
	public void deleteEvent(int eid) {
		dao.deleteEvent(eid);
	}

}
