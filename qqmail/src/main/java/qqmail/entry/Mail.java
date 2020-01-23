package qqmail.entry;

import java.util.Date;

//邮件表
public class Mail {
    private int mail_id;//邮件id
    private String motive;//主题
    private String main_body;//正文
    private int status_id;//邮件的状态id
    private int send_mail_id;//发件人的id
    private int accept_mail_id;//收件人的id
    private Date send_time;//发送的邮件的日期
    private int notepaper_id;//信纸id
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
	public int getAccept_mail_id() {
		return accept_mail_id;
	}
	public void setAccept_mail_id(int accept_mail_id) {
		this.accept_mail_id = accept_mail_id;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public int getNotepaper_id() {
		return notepaper_id;
	}
	public void setNotepaper_id(int notepaper_id) {
		this.notepaper_id = notepaper_id;
	}
	@Override
	public String toString() {
		return "Mail [mail_id=" + mail_id + ", motive=" + motive
				+ ", main_body=" + main_body + ", status_id=" + status_id
				+ ", send_mail_id=" + send_mail_id + ", accept_mail_id="
				+ accept_mail_id + ", send_time=" + send_time
				+ ", notepaper_id=" + notepaper_id + "]";
	}
    
}