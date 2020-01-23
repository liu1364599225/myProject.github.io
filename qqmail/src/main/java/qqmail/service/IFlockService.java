package qqmail.service;

import java.util.List;

import qqmail.entry.MailPro;
import qqmail.entry.Status;

public interface IFlockService {
	public abstract List<MailPro> readAll_Flock_Count(String flock,int accept_id);//联表查询（状态表和邮件表）
	
	//public abstract List<Linkman_group> readAll_Linkman(int accept_id);//查询所以群组；
	
	public abstract MailPro readAll_Flock_ById(String flock,int accept_id,int time);//查对应的单个邮件
	
	public abstract List<MailPro> readAll_Flock(String flock,int send_id,int begin,int end);//分页——联表查询（状态表和邮件表）
	
	public abstract List<MailPro> readAll_FlockPro(String flock,int send_id);//未读邮件数查询
	
	public abstract Status readBySendId(int senId,int time);//根据发送人id和时间拿到状态id对应状态表中的内容
	
	public abstract void update(String afind,String unfind,int id);//更新邮箱有未查看状态
	
	public abstract void updateStar(String star,int id);//更新星标状态
	
	public abstract void updateDeletes(String deletes,int id);//加入删除状态
	
	public abstract void updateReport(String deletes,int id);//加入垃圾箱状态
	
	public abstract void updateInbox(String lnbox,int id);//更新收件箱状态
	
	public abstract void deleteTrue(int statusId); //彻底删除
	
	public abstract void updateAsend(String asend,String unsend,int id);//更新邮箱发送状态
	
}
