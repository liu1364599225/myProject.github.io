package qqmail.entry;

import java.util.Date;

//日历的事件表
public class Event {
    private int eid;//事件的id
    private String title;//事件的标题
    private Date start;//事件的开始时间
    private Date end;//事件的结束时间
    private int master;//事件的用户
    
    public Event(){
    	
    }
	
	public Event(String title, Date start, Date end, int master) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.master = master;
	}


	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getMaster() {
		return master;
	}
	public void setMaster(int master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Event [eid=" + eid + ", title=" + title + ", start=" + start
				+ ", end=" + end + ", master=" + master + "]";
	}
}
