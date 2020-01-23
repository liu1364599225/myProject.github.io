package qqmail.entry;
//邮件的状态表
public class Status {
    private int mail_status_id;//邮箱状态表的id
    private String inbox;//收件箱的状态
    private String bit_mail;//星标邮件的状态
    private String send;//发件箱的状态
    private String deletes;//删除的状态
    private String garbage;//垃圾箱状态
    private String draft;//草稿箱的状态
    private String asend;//已发送状态
    private String unsend;//未发送状态
    private String afind;//已发送状态
    private String unfind;//未发送状态
    private String group_mail;//群邮件
    
    
    
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
		return "Status [mail_status_id=" + mail_status_id + ", inbox=" + inbox
				+ ", bit_mail=" + bit_mail + ", send=" + send + ", deletes="
				+ deletes + ", garbage=" + garbage + ", draft=" + draft
				+ ", asend=" + asend + ", unsend=" + unsend + ", afind="
				+ afind + ", unfind=" + unfind + ", group_mail=" + group_mail
				+ "]";
	}
	


	
	
}
