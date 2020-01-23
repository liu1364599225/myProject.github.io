package qqmail.entry;

import java.util.Date;

/**
 * 
 * @author 童成
 *	用于更方便查找数据，集合Status类和Mail类的属性
 */
public class MailPro {
	 private int mail_id;//邮件id
	    private String motive;//主题
	    private String main_body;//正文
	    private int status_id;//邮件的状态id
	    private int send_mail_id;//发件人的id
	    private String accept_mail_id;//收件人的id
	    private Date send_time;//发送的邮件的日期
	    private String date;//字符串转换使用
	    private int mail_status_id;//邮箱状态表的id
	    private String inbox;//收件箱的状态
	    private String bit_mail;//星标邮件的状态
	    private String send;//发件箱的状态
	    private String deletes;//删除的状态
	    private String garbage;//垃圾箱状态
	    private String draft;//草稿箱的状态
	    private String asend;//已发送状态
	    private String unsend;//未发送状态
	    private int notepaper_id;//邮件背景
	    private String afind;//已发送状态
	    private String unfind;//未发送状态
	    private String group_mail;//群邮件
	    
	    
		public MailPro() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		public String getGroup_mail() {
			return group_mail;
		}





		public void setGroup_mail(String group_mail) {
			this.group_mail = group_mail;
		}





		public String getAfind() {
			return afind;
		}

		public void setAfind(String afind) {
			this.afind = afind;
		}

		public String getUnfind() {
			return unfind;
		}

		public void setUnfind(String unfind) {
			this.unfind = unfind;
		}

		public int getNotepaper_id() {
			return notepaper_id;
		}

		public void setNotepaper_id(int notepaper_id) {
			this.notepaper_id = notepaper_id;
		}

	

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getAsend() {
			return asend;
		}

		public void setAsend(String asend) {
			this.asend = asend;
		}

		public String getUnsend() {
			return unsend;
		}

		public void setUnsend(String unsend) {
			this.unsend = unsend;
		}

		public int getMail_id() {
			return mail_id;
		}
		public void setMail_id(int mail_id) {
			this.mail_id = mail_id;
		}
		public String getMotive() {
			return motive;
		}
		public void setMotive(String motive) {
			this.motive = motive;
		}
		public String getMain_body() {
			return main_body;
		}
		public void setMain_body(String main_body) {
			this.main_body = main_body;
		}
		public int getStatus_id() {
			return status_id;
		}
		public void setStatus_id(int status_id) {
			this.status_id = status_id;
		}
		public int getSend_mail_id() {
			return send_mail_id;
		}
		public void setSend_mail_id(int send_mail_id) {
			this.send_mail_id = send_mail_id;
		}
		public String getAccept_mail_id() {
			return accept_mail_id;
		}
		public void setAccept_mail_id(String accept_mail_id) {
			this.accept_mail_id = accept_mail_id;
		}
		public Date getSend_time() {
			return send_time;
		}
		public void setSend_time(Date send_time) {
			this.send_time = send_time;
		}
		public int getMail_status_id() {
			return mail_status_id;
		}
		public void setMail_status_id(int mail_status_id) {
			this.mail_status_id = mail_status_id;
		}
		public String getInbox() {
			return inbox;
		}
		public void setInbox(String inbox) {
			this.inbox = inbox;
		}
		public String getBit_mail() {
			return bit_mail;
		}
		public void setBit_mail(String bit_mail) {
			this.bit_mail = bit_mail;
		}
		public String getSend() {
			return send;
		}
		public void setSend(String send) {
			this.send = send;
		}
		public String getDeletes() {
			return deletes;
		}
		public void setDeletes(String deletes) {
			this.deletes = deletes;
		}
		public String getGarbage() {
			return garbage;
		}
		public void setGarbage(String garbage) {
			this.garbage = garbage;
		}
		public String getDraft() {
			return draft;
		}
		public void setDraft(String draft) {
			this.draft = draft;
		}





		@Override
		public String toString() {
			return "MailPro [mail_id=" + mail_id + ", motive=" + motive
					+ ", main_body=" + main_body + ", status_id=" + status_id
					+ ", send_mail_id=" + send_mail_id + ", accept_mail_id="
					+ accept_mail_id + ", send_time=" + send_time + ", date="
					+ date + ", mail_status_id=" + mail_status_id + ", inbox="
					+ inbox + ", bit_mail=" + bit_mail + ", send=" + send
					+ ", deletes=" + deletes + ", garbage=" + garbage
					+ ", draft=" + draft + ", asend=" + asend + ", unsend="
					+ unsend + ", notepaper_id=" + notepaper_id + ", afind="
					+ afind + ", unfind=" + unfind + ", group_mail="
					+ group_mail + "]";
		}
		
		
		
	    
	    
}
